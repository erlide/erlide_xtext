package org.erlide.erlang.parserdb

import com.google.common.io.Files
import java.io.File
import java.io.PrintStream
import java.nio.charset.Charset
import java.util.List
import java.util.Scanner
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.erlide.ErlangInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.erlide.erlang.Module
import org.erlide.erlang.util.Histogram

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(ErlangInjectorProvider))
public class ParserDbTest extends XtextTest {

	def loadDB(String db) {
		Files::readLines(new File(db), Charset::defaultCharset)
	}

	@Test
	def void parseDbXtext() {
		parseDb("/home/qvladum/parserDB.txt")
	}

	@Test
	def void parseDbXtextErrs() {
		parseDb("/home/qvladum/parserDB_Xtext_err.txt")
	}

	
	def void parseDb(String db) {
		var long time = System::currentTimeMillis
		
		val out1 = new PrintStream(new File("/home/qvladum/parserDB_Xtext.log"))
		val modules = loadDB(db)
		val out2 = new PrintStream(new File("/home/qvladum/parserDB_Xtext_err.txt"))
		val out3 = new PrintStream(new File("/home/qvladum/parserDB_Xtext_err.log"))

		var long delta = System::currentTimeMillis - time
		println("loaded in "+ delta/1000)
		time = System::currentTimeMillis

   	    resourceRoot="file:"

		var numok=0
		var err=0
		var long maxtime=0
		val histo = new Histogram()
		for(path: modules){
			if(!path.endsWith(".yrl") && 
				!path.contains("/product/personal/") && 
				!path.contains("/api_gen/wx_extra/")
			){
				out1.println("!!! "+path)
				println("!!! "+path)
		        val uri = URI::createURI("file:/" + path)
	    	    try {
	    	    	resourceSet.resources.clear
	    	    	issues = null
	    	    	//testFileNoSerializer(mi.path)
	
					val mystart = System::currentTimeMillis
	    	    	val rootElement = loadModel(resourceSet, uri, typeof(Module))
	    	    	val mytime = System::currentTimeMillis - mystart
	    	    	maxtime = Math::max(maxtime, mytime)
	    	    	histo.add(mytime/100)
					numok=numok+1	
	    	    } catch(Throwable e) {
	    	    	out1.println("  error parsing: "+e.message)
	    	    	println("  error parsing: "+e.message)
	    	    	err=err+1
	    	    	out2.println(path)
	    	    	out3.println(path)
	    	    	out3.println(e.message)
	    	    }
    	    }
		}	
		val tot = numok+err
		out1.println("--- ok="+numok+" err="+err+" /"+tot)
		println("--- ok="+numok+" err="+err+" /"+tot)
		out1.println("  - longest parse: "+maxtime+"ms")
		println("  - longest parse: "+maxtime+"ms")
		delta = System::currentTimeMillis - time
		println("took "+ delta/1000+"s")
		
		histo.print(System::out)
	}

	def ModuleInfo parseModule(List<String> lines) {
		val hdr = lines.remove(0)
		val result = new ModuleInfo()
		val scan = new Scanner(hdr)
		//println("::: "+hdr)
		result.path = scan.next
		var num = scan.nextInt
		while (num > 0) {
			num = num-1
			val form = parseForm(lines)
			result.forms.add(form)
		}
		return result
	}

	def FormInfo parseForm(List<String> lines) {
		val hdr = lines.remove(0)
		val result = new FormInfo()
		val scan = new Scanner(hdr)
		result.kind = scan.next
		switch result.kind {
			case "ATTRIBUTE":
				{
					result.name = scan.next
				}
			case "EXPORT":
				result.children = scan.nextInt
			case "IMPORT":
				result.children = scan.nextInt
			case "RECORD_DEF":
				result.name = scan.next
			case "TYPESPEC": 
				{
					try {
						result.name = scan.next 
					} catch (Exception e) { 
						result.name="?"
					}
					try {
						result.arg = scan.next
					} catch (Exception e) { 
						result.arg="?"
					}
				}
			case "MACRO_DEF":
				result.name = scan.next
			case "FUNCTION":
				{
					result.name = scan.next
					result.arity = scan.nextInt
					result.children = scan.nextInt
				}
			default:
				null
		}
		return result
	}

}
