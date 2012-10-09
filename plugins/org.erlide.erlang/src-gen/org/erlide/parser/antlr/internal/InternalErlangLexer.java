package org.erlide.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalErlangLexer extends Lexer {
    public static final int RULE_ESCAPE=13;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ATOM_STARTER=11;
    public static final int EOF=-1;
    public static final int RULE_ATOM=5;
    public static final int RULE_IN_WORD_CHAR=12;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__19=19;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int RULE_BASED_INT=9;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int RULE_CHAR=6;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_HEX_DIGIT=17;
    public static final int RULE_COMMENT=14;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_STRING=4;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_VARIABLE=7;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int RULE_EXT_INT=10;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int RULE_INT=8;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=15;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=16;

    // delegates
    // delegators

    public InternalErlangLexer() {;} 
    public InternalErlangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalErlangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:11:7: ( '.' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:11:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:12:7: ( '-' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:12:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:13:7: ( 'define' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:13:9: 'define'
            {
            match("define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:14:7: ( '(' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:15:7: ( ',' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:16:7: ( ')' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:17:7: ( 'undef' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:17:9: 'undef'
            {
            match("undef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:18:7: ( 'ifdef' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:18:9: 'ifdef'
            {
            match("ifdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:19:7: ( 'ifndef' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:19:9: 'ifndef'
            {
            match("ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:20:7: ( 'else' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:20:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:21:7: ( 'endif' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:21:9: 'endif'
            {
            match("endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:22:7: ( 'include' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:22:9: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:23:7: ( 'include_lib' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:23:9: 'include_lib'
            {
            match("include_lib"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:24:7: ( 'file' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:24:9: 'file'
            {
            match("file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:25:7: ( 'module' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:25:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:26:7: ( 'encoding' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:26:9: 'encoding'
            {
            match("encoding"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:27:7: ( 'record' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:27:9: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:28:7: ( '{' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:28:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:29:7: ( '}' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:29:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:30:7: ( '=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:30:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:31:7: ( '::' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:31:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:32:7: ( 'export' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:32:9: 'export'
            {
            match("export"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:33:7: ( '[' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:33:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:34:7: ( ']' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:34:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:35:7: ( 'import' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:35:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:36:7: ( 'compile' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:36:9: 'compile'
            {
            match("compile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:37:7: ( 'spec' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:37:9: 'spec'
            {
            match("spec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:38:7: ( 'callback' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:38:9: 'callback'
            {
            match("callback"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:39:7: ( ';' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:39:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:40:7: ( 'type' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:40:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:41:7: ( 'opaque' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:41:9: 'opaque'
            {
            match("opaque"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:42:7: ( 'when' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:42:9: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:43:7: ( '->' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:43:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:44:7: ( '?' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:44:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:45:7: ( 'line' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:45:9: 'line'
            {
            match("line"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:46:7: ( 'catch' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:46:9: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:47:7: ( 'orelse' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:47:9: 'orelse'
            {
            match("orelse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:48:7: ( 'andalso' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:48:9: 'andalso'
            {
            match("andalso"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:49:7: ( '#' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:49:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:50:7: ( ':' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:50:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:51:7: ( 'begin' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:51:9: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:52:7: ( 'end' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:52:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:53:7: ( 'query' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:53:9: 'query'
            {
            match("query"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:54:7: ( 'cond' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:54:9: 'cond'
            {
            match("cond"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:55:7: ( 'let' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:55:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:56:7: ( 'if' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:56:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:57:7: ( 'case' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:57:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:58:7: ( 'of' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:58:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:59:7: ( 'receive' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:59:9: 'receive'
            {
            match("receive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:60:7: ( 'after' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:60:9: 'after'
            {
            match("after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:61:7: ( 'fun' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:61:9: 'fun'
            {
            match("fun"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:62:7: ( '/' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:62:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:63:7: ( 'try' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:63:9: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:64:7: ( '|' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:64:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:65:7: ( '||' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:65:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:66:7: ( '<<' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:66:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:67:7: ( '>>' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:67:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:68:7: ( '<-' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:68:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:69:7: ( '<=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:69:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:70:7: ( '+' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:70:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:71:7: ( 'bor' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:71:9: 'bor'
            {
            match("bor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:72:7: ( 'bxor' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:72:9: 'bxor'
            {
            match("bxor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:73:7: ( 'bsl' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:73:9: 'bsl'
            {
            match("bsl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:74:7: ( 'bsr' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:74:9: 'bsr'
            {
            match("bsr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:75:7: ( 'or' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:75:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:76:7: ( 'xor' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:76:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:77:7: ( '*' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:77:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:78:7: ( 'div' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:78:9: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:79:7: ( 'rem' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:79:9: 'rem'
            {
            match("rem"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:80:7: ( 'band' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:80:9: 'band'
            {
            match("band"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:81:7: ( 'and' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:81:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:82:7: ( 'bnot' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:82:9: 'bnot'
            {
            match("bnot"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:83:7: ( 'not' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:83:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:84:7: ( '++' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:84:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:85:7: ( '--' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:85:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:86:7: ( '==' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:86:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:87:7: ( '/=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:87:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:88:7: ( '=<' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:88:9: '=<'
            {
            match("=<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:89:7: ( '<' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:89:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:90:7: ( '>=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:90:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:91:7: ( '>' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:91:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:92:7: ( '=:=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:92:9: '=:='
            {
            match("=:="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:93:8: ( '=/=' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:93:10: '=/='
            {
            match("=/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:94:8: ( '!' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:94:10: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:95:8: ( '??' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:95:10: '??'
            {
            match("??"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:96:8: ( '..' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:96:10: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:97:8: ( '...' )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:97:10: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "RULE_ATOM"
    public final void mRULE_ATOM() throws RecognitionException {
        try {
            int _type = RULE_ATOM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:11: ( ( RULE_ATOM_STARTER ( RULE_IN_WORD_CHAR )* | '\\'' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | EOF ) ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:13: ( RULE_ATOM_STARTER ( RULE_IN_WORD_CHAR )* | '\\'' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | EOF ) )
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:13: ( RULE_ATOM_STARTER ( RULE_IN_WORD_CHAR )* | '\\'' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | EOF ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00DF' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:14: RULE_ATOM_STARTER ( RULE_IN_WORD_CHAR )*
                    {
                    mRULE_ATOM_STARTER(); 
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:32: ( RULE_IN_WORD_CHAR )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='@' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')||(LA1_0>='\u00C0' && LA1_0<='\u00D6')||(LA1_0>='\u00D8' && LA1_0<='\u00F6')||(LA1_0>='\u00F8' && LA1_0<='\u00FF')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:32: RULE_IN_WORD_CHAR
                    	    {
                    	    mRULE_IN_WORD_CHAR(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:51: '\\'' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' | EOF )
                    {
                    match('\''); 
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:56: ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\\') ) {
                            alt2=1;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='&')||(LA2_0>='(' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:57: '\\\\' RULE_ESCAPE
                    	    {
                    	    match('\\'); 
                    	    mRULE_ESCAPE(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:74: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:91: ( '\\'' | EOF )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\'') ) {
                        alt3=1;
                    }
                    else {
                        alt3=2;}
                    switch (alt3) {
                        case 1 :
                            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:92: '\\''
                            {
                            match('\''); 

                            }
                            break;
                        case 2 :
                            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9297:97: EOF
                            {
                            match(EOF); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ATOM"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:13: ( '\"' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | EOF ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:15: '\"' ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' | EOF )
            {
            match('\"'); 
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:19: ( '\\\\' RULE_ESCAPE | ~ ( ( '\\\\' | '\"' ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:20: '\\\\' RULE_ESCAPE
            	    {
            	    match('\\'); 
            	    mRULE_ESCAPE(); 

            	    }
            	    break;
            	case 2 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:37: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:53: ( '\"' | EOF )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else {
                alt6=2;}
            switch (alt6) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:54: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9299:58: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_VARIABLE"
    public final void mRULE_VARIABLE() throws RecognitionException {
        try {
            int _type = RULE_VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9301:15: ( ( 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DE' ) ( RULE_IN_WORD_CHAR )* )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9301:17: ( 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DE' ) ( RULE_IN_WORD_CHAR )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00DE') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9301:70: ( RULE_IN_WORD_CHAR )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='@' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')||(LA7_0>='\u00C0' && LA7_0<='\u00D6')||(LA7_0>='\u00D8' && LA7_0<='\u00F6')||(LA7_0>='\u00F8' && LA7_0<='\u00FF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9301:70: RULE_IN_WORD_CHAR
            	    {
            	    mRULE_IN_WORD_CHAR(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VARIABLE"

    // $ANTLR start "RULE_COMMENT"
    public final void mRULE_COMMENT() throws RecognitionException {
        try {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:23: ( '%' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' | EOF ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:25: '%' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' | EOF )
            {
            match('%'); 
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:29: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:29: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:45: ( ( '\\r' )? '\\n' | EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            else {
                alt10=2;}
            switch (alt10) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:46: ( '\\r' )? '\\n'
                    {
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:46: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:46: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9303:57: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9305:17: ( ( RULE_COMMENT )+ )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9305:19: ( RULE_COMMENT )+
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9305:19: ( RULE_COMMENT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='%') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9305:19: RULE_COMMENT
            	    {
            	    mRULE_COMMENT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9307:9: ( (~ ( ( '!' .. '~' | '\\u00A1' .. '\\u00FF' ) ) )+ )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9307:11: (~ ( ( '!' .. '~' | '\\u00A1' .. '\\u00FF' ) ) )+
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9307:11: (~ ( ( '!' .. '~' | '\\u00A1' .. '\\u00FF' ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<=' ')||(LA12_0>='\u007F' && LA12_0<='\u00A0')||(LA12_0>='\u0100' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9307:11: ~ ( ( '!' .. '~' | '\\u00A1' .. '\\u00FF' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=' ')||(input.LA(1)>='\u007F' && input.LA(1)<='\u00A0')||(input.LA(1)>='\u0100' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_BASED_INT"
    public final void mRULE_BASED_INT() throws RecognitionException {
        try {
            int _type = RULE_BASED_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9309:16: ( ( '1' .. '3' )? '0' .. '9' '#' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9309:18: ( '1' .. '3' )? '0' .. '9' '#' ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9309:18: ( '1' .. '3' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>='1' && LA13_0<='3')) ) {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1>='0' && LA13_1<='9')) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9309:19: '1' .. '3'
                    {
                    matchRange('1','3'); 

                    }
                    break;

            }

            matchRange('0','9'); 
            match('#'); 
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9309:43: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9311:10: ( ( '0' .. '9' )+ )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9311:12: ( '0' .. '9' )+
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9311:12: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9311:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_EXT_INT"
    public final void mRULE_EXT_INT() throws RecognitionException {
        try {
            int _type = RULE_EXT_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9313:14: ( RULE_INT ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9313:16: RULE_INT ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
            {
            mRULE_INT(); 
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9313:35: ( '+' | '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='+'||LA16_0=='-') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXT_INT"

    // $ANTLR start "RULE_CHAR"
    public final void mRULE_CHAR() throws RecognitionException {
        try {
            int _type = RULE_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9315:11: ( '$' ( '\\\\' RULE_ESCAPE | . ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9315:13: '$' ( '\\\\' RULE_ESCAPE | . )
            {
            match('$'); 
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9315:17: ( '\\\\' RULE_ESCAPE | . )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\\') ) {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>='\u0000' && LA17_1<='\uFFFF')) ) {
                    alt17=1;
                }
                else {
                    alt17=2;}
            }
            else if ( ((LA17_0>='\u0000' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9315:18: '\\\\' RULE_ESCAPE
                    {
                    match('\\'); 
                    mRULE_ESCAPE(); 

                    }
                    break;
                case 2 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9315:35: .
                    {
                    matchAny(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHAR"

    // $ANTLR start "RULE_IN_WORD_CHAR"
    public final void mRULE_IN_WORD_CHAR() throws RecognitionException {
        try {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9317:28: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '@' | '0' .. '9' | '\\u00DF' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DE' ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9317:30: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '@' | '0' .. '9' | '\\u00DF' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00DE' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='@' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IN_WORD_CHAR"

    // $ANTLR start "RULE_ATOM_STARTER"
    public final void mRULE_ATOM_STARTER() throws RecognitionException {
        try {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9319:28: ( ( 'a' .. 'z' | '\\u00DF' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9319:30: ( 'a' .. 'z' | '\\u00DF' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            {
            if ( (input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00DF' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u00FF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ATOM_STARTER"

    // $ANTLR start "RULE_ESCAPE"
    public final void mRULE_ESCAPE() throws RecognitionException {
        try {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:22: ( ( 'b' | 'd' | 'e' | 'f' | 'n' | 'r' | 's' | 't' | 'v' | '0' .. '7' ( '0' .. '7' ( '0' .. '7' )? )? | ( 'x' | 'X' ) RULE_HEX_DIGIT RULE_HEX_DIGIT | ( 'x' | 'X' ) '{' ( RULE_HEX_DIGIT )+ '}' | '^' ( 'a' .. 'z' | 'A' .. 'Z' | ']' ) | . ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:24: ( 'b' | 'd' | 'e' | 'f' | 'n' | 'r' | 's' | 't' | 'v' | '0' .. '7' ( '0' .. '7' ( '0' .. '7' )? )? | ( 'x' | 'X' ) RULE_HEX_DIGIT RULE_HEX_DIGIT | ( 'x' | 'X' ) '{' ( RULE_HEX_DIGIT )+ '}' | '^' ( 'a' .. 'z' | 'A' .. 'Z' | ']' ) | . )
            {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:24: ( 'b' | 'd' | 'e' | 'f' | 'n' | 'r' | 's' | 't' | 'v' | '0' .. '7' ( '0' .. '7' ( '0' .. '7' )? )? | ( 'x' | 'X' ) RULE_HEX_DIGIT RULE_HEX_DIGIT | ( 'x' | 'X' ) '{' ( RULE_HEX_DIGIT )+ '}' | '^' ( 'a' .. 'z' | 'A' .. 'Z' | ']' ) | . )
            int alt21=14;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:25: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:29: 'd'
                    {
                    match('d'); 

                    }
                    break;
                case 3 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:33: 'e'
                    {
                    match('e'); 

                    }
                    break;
                case 4 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:37: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:41: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 6 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:45: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 7 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:49: 's'
                    {
                    match('s'); 

                    }
                    break;
                case 8 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:53: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:57: 'v'
                    {
                    match('v'); 

                    }
                    break;
                case 10 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:61: '0' .. '7' ( '0' .. '7' ( '0' .. '7' )? )?
                    {
                    matchRange('0','7'); 
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:70: ( '0' .. '7' ( '0' .. '7' )? )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>='0' && LA19_0<='7')) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:71: '0' .. '7' ( '0' .. '7' )?
                            {
                            matchRange('0','7'); 
                            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:80: ( '0' .. '7' )?
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( ((LA18_0>='0' && LA18_0<='7')) ) {
                                alt18=1;
                            }
                            switch (alt18) {
                                case 1 :
                                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:81: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:94: ( 'x' | 'X' ) RULE_HEX_DIGIT RULE_HEX_DIGIT
                    {
                    if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mRULE_HEX_DIGIT(); 
                    mRULE_HEX_DIGIT(); 

                    }
                    break;
                case 12 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:134: ( 'x' | 'X' ) '{' ( RULE_HEX_DIGIT )+ '}'
                    {
                    if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    match('{'); 
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:148: ( RULE_HEX_DIGIT )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='F')||(LA20_0>='a' && LA20_0<='f')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:148: RULE_HEX_DIGIT
                    	    {
                    	    mRULE_HEX_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    match('}'); 

                    }
                    break;
                case 13 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:168: '^' ( 'a' .. 'z' | 'A' .. 'Z' | ']' )
                    {
                    match('^'); 
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)==']'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 14 :
                    // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9321:196: .
                    {
                    matchAny(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESCAPE"

    // $ANTLR start "RULE_HEX_DIGIT"
    public final void mRULE_HEX_DIGIT() throws RecognitionException {
        try {
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9323:25: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:9323:27: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX_DIGIT"

    public void mTokens() throws RecognitionException {
        // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | RULE_ATOM | RULE_STRING | RULE_VARIABLE | RULE_SL_COMMENT | RULE_WS | RULE_BASED_INT | RULE_INT | RULE_EXT_INT | RULE_CHAR )
        int alt22=96;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:10: T__18
                {
                mT__18(); 

                }
                break;
            case 2 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:16: T__19
                {
                mT__19(); 

                }
                break;
            case 3 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:22: T__20
                {
                mT__20(); 

                }
                break;
            case 4 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:28: T__21
                {
                mT__21(); 

                }
                break;
            case 5 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:34: T__22
                {
                mT__22(); 

                }
                break;
            case 6 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:40: T__23
                {
                mT__23(); 

                }
                break;
            case 7 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:46: T__24
                {
                mT__24(); 

                }
                break;
            case 8 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:52: T__25
                {
                mT__25(); 

                }
                break;
            case 9 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:58: T__26
                {
                mT__26(); 

                }
                break;
            case 10 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:64: T__27
                {
                mT__27(); 

                }
                break;
            case 11 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:70: T__28
                {
                mT__28(); 

                }
                break;
            case 12 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:76: T__29
                {
                mT__29(); 

                }
                break;
            case 13 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:82: T__30
                {
                mT__30(); 

                }
                break;
            case 14 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:88: T__31
                {
                mT__31(); 

                }
                break;
            case 15 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:94: T__32
                {
                mT__32(); 

                }
                break;
            case 16 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:100: T__33
                {
                mT__33(); 

                }
                break;
            case 17 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:106: T__34
                {
                mT__34(); 

                }
                break;
            case 18 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:112: T__35
                {
                mT__35(); 

                }
                break;
            case 19 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:118: T__36
                {
                mT__36(); 

                }
                break;
            case 20 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:124: T__37
                {
                mT__37(); 

                }
                break;
            case 21 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:130: T__38
                {
                mT__38(); 

                }
                break;
            case 22 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:136: T__39
                {
                mT__39(); 

                }
                break;
            case 23 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:142: T__40
                {
                mT__40(); 

                }
                break;
            case 24 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:148: T__41
                {
                mT__41(); 

                }
                break;
            case 25 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:154: T__42
                {
                mT__42(); 

                }
                break;
            case 26 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:160: T__43
                {
                mT__43(); 

                }
                break;
            case 27 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:166: T__44
                {
                mT__44(); 

                }
                break;
            case 28 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:172: T__45
                {
                mT__45(); 

                }
                break;
            case 29 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:178: T__46
                {
                mT__46(); 

                }
                break;
            case 30 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:184: T__47
                {
                mT__47(); 

                }
                break;
            case 31 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:190: T__48
                {
                mT__48(); 

                }
                break;
            case 32 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:196: T__49
                {
                mT__49(); 

                }
                break;
            case 33 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:202: T__50
                {
                mT__50(); 

                }
                break;
            case 34 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:208: T__51
                {
                mT__51(); 

                }
                break;
            case 35 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:214: T__52
                {
                mT__52(); 

                }
                break;
            case 36 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:220: T__53
                {
                mT__53(); 

                }
                break;
            case 37 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:226: T__54
                {
                mT__54(); 

                }
                break;
            case 38 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:232: T__55
                {
                mT__55(); 

                }
                break;
            case 39 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:238: T__56
                {
                mT__56(); 

                }
                break;
            case 40 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:244: T__57
                {
                mT__57(); 

                }
                break;
            case 41 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:250: T__58
                {
                mT__58(); 

                }
                break;
            case 42 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:256: T__59
                {
                mT__59(); 

                }
                break;
            case 43 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:262: T__60
                {
                mT__60(); 

                }
                break;
            case 44 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:268: T__61
                {
                mT__61(); 

                }
                break;
            case 45 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:274: T__62
                {
                mT__62(); 

                }
                break;
            case 46 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:280: T__63
                {
                mT__63(); 

                }
                break;
            case 47 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:286: T__64
                {
                mT__64(); 

                }
                break;
            case 48 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:292: T__65
                {
                mT__65(); 

                }
                break;
            case 49 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:298: T__66
                {
                mT__66(); 

                }
                break;
            case 50 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:304: T__67
                {
                mT__67(); 

                }
                break;
            case 51 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:310: T__68
                {
                mT__68(); 

                }
                break;
            case 52 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:316: T__69
                {
                mT__69(); 

                }
                break;
            case 53 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:322: T__70
                {
                mT__70(); 

                }
                break;
            case 54 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:328: T__71
                {
                mT__71(); 

                }
                break;
            case 55 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:334: T__72
                {
                mT__72(); 

                }
                break;
            case 56 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:340: T__73
                {
                mT__73(); 

                }
                break;
            case 57 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:346: T__74
                {
                mT__74(); 

                }
                break;
            case 58 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:352: T__75
                {
                mT__75(); 

                }
                break;
            case 59 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:358: T__76
                {
                mT__76(); 

                }
                break;
            case 60 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:364: T__77
                {
                mT__77(); 

                }
                break;
            case 61 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:370: T__78
                {
                mT__78(); 

                }
                break;
            case 62 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:376: T__79
                {
                mT__79(); 

                }
                break;
            case 63 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:382: T__80
                {
                mT__80(); 

                }
                break;
            case 64 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:388: T__81
                {
                mT__81(); 

                }
                break;
            case 65 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:394: T__82
                {
                mT__82(); 

                }
                break;
            case 66 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:400: T__83
                {
                mT__83(); 

                }
                break;
            case 67 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:406: T__84
                {
                mT__84(); 

                }
                break;
            case 68 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:412: T__85
                {
                mT__85(); 

                }
                break;
            case 69 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:418: T__86
                {
                mT__86(); 

                }
                break;
            case 70 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:424: T__87
                {
                mT__87(); 

                }
                break;
            case 71 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:430: T__88
                {
                mT__88(); 

                }
                break;
            case 72 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:436: T__89
                {
                mT__89(); 

                }
                break;
            case 73 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:442: T__90
                {
                mT__90(); 

                }
                break;
            case 74 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:448: T__91
                {
                mT__91(); 

                }
                break;
            case 75 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:454: T__92
                {
                mT__92(); 

                }
                break;
            case 76 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:460: T__93
                {
                mT__93(); 

                }
                break;
            case 77 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:466: T__94
                {
                mT__94(); 

                }
                break;
            case 78 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:472: T__95
                {
                mT__95(); 

                }
                break;
            case 79 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:478: T__96
                {
                mT__96(); 

                }
                break;
            case 80 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:484: T__97
                {
                mT__97(); 

                }
                break;
            case 81 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:490: T__98
                {
                mT__98(); 

                }
                break;
            case 82 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:496: T__99
                {
                mT__99(); 

                }
                break;
            case 83 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:502: T__100
                {
                mT__100(); 

                }
                break;
            case 84 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:509: T__101
                {
                mT__101(); 

                }
                break;
            case 85 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:516: T__102
                {
                mT__102(); 

                }
                break;
            case 86 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:523: T__103
                {
                mT__103(); 

                }
                break;
            case 87 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:530: T__104
                {
                mT__104(); 

                }
                break;
            case 88 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:537: RULE_ATOM
                {
                mRULE_ATOM(); 

                }
                break;
            case 89 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:547: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 90 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:559: RULE_VARIABLE
                {
                mRULE_VARIABLE(); 

                }
                break;
            case 91 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:573: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 92 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:589: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 93 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:597: RULE_BASED_INT
                {
                mRULE_BASED_INT(); 

                }
                break;
            case 94 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:612: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 95 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:621: RULE_EXT_INT
                {
                mRULE_EXT_INT(); 

                }
                break;
            case 96 :
                // ../org.erlide.erlang/src-gen/org/erlide/parser/antlr/internal/InternalErlang.g:1:634: RULE_CHAR
                {
                mRULE_CHAR(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA21_eotS =
        "\13\uffff\2\15\4\uffff";
    static final String DFA21_eofS =
        "\21\uffff";
    static final String DFA21_minS =
        "\1\0\12\uffff\1\60\1\101\4\uffff";
    static final String DFA21_maxS =
        "\1\uffff\12\uffff\1\173\1\172\4\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff\1\16"+
        "\1\14\1\13\1\15";
    static final String DFA21_specialS =
        "\1\0\20\uffff}>";
    static final String[] DFA21_transitionS = {
            "\60\15\10\12\40\15\1\13\5\15\1\14\3\15\1\1\1\15\1\2\1\3\1\4"+
            "\7\15\1\5\3\15\1\6\1\7\1\10\1\15\1\11\1\15\1\13\uff87\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\17\7\uffff\6\17\32\uffff\6\17\24\uffff\1\16",
            "\32\20\2\uffff\1\20\3\uffff\32\20",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "9321:24: ( 'b' | 'd' | 'e' | 'f' | 'n' | 'r' | 's' | 't' | 'v' | '0' .. '7' ( '0' .. '7' ( '0' .. '7' )? )? | ( 'x' | 'X' ) RULE_HEX_DIGIT RULE_HEX_DIGIT | ( 'x' | 'X' ) '{' ( RULE_HEX_DIGIT )+ '}' | '^' ( 'a' .. 'z' | 'A' .. 'Z' | ']' ) | . )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='b') ) {s = 1;}

                        else if ( (LA21_0=='d') ) {s = 2;}

                        else if ( (LA21_0=='e') ) {s = 3;}

                        else if ( (LA21_0=='f') ) {s = 4;}

                        else if ( (LA21_0=='n') ) {s = 5;}

                        else if ( (LA21_0=='r') ) {s = 6;}

                        else if ( (LA21_0=='s') ) {s = 7;}

                        else if ( (LA21_0=='t') ) {s = 8;}

                        else if ( (LA21_0=='v') ) {s = 9;}

                        else if ( ((LA21_0>='0' && LA21_0<='7')) ) {s = 10;}

                        else if ( (LA21_0=='X'||LA21_0=='x') ) {s = 11;}

                        else if ( (LA21_0=='^') ) {s = 12;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='/')||(LA21_0>='8' && LA21_0<='W')||(LA21_0>='Y' && LA21_0<=']')||(LA21_0>='_' && LA21_0<='a')||LA21_0=='c'||(LA21_0>='g' && LA21_0<='m')||(LA21_0>='o' && LA21_0<='q')||LA21_0=='u'||LA21_0=='w'||(LA21_0>='y' && LA21_0<='\uFFFF')) ) {s = 13;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\1\uffff\1\61\1\64\1\50\3\uffff\6\50\2\uffff\1\106\1\110\2\uffff"+
        "\2\50\1\uffff\3\50\1\123\2\50\1\uffff\2\50\1\140\1\142\1\146\1\151"+
        "\1\153\1\50\1\uffff\1\50\6\uffff\2\157\1\uffff\1\163\4\uffff\3\50"+
        "\1\171\11\50\7\uffff\6\50\1\u008f\1\u0090\1\50\2\uffff\13\50\15"+
        "\uffff\2\50\3\uffff\1\157\2\uffff\1\50\1\u00a1\3\50\1\uffff\3\50"+
        "\1\u00a9\3\50\1\u00ad\2\50\1\u00b1\7\50\1\u00b9\2\50\2\uffff\2\50"+
        "\1\u00be\1\u00c0\2\50\1\u00c3\1\50\1\u00c5\1\u00c6\3\50\1\u00ca"+
        "\1\u00cb\1\50\1\uffff\5\50\1\u00d2\1\50\1\uffff\2\50\1\u00d6\1\uffff"+
        "\3\50\1\uffff\1\50\1\u00db\2\50\1\u00de\1\u00df\1\u00e0\1\uffff"+
        "\2\50\1\u00e3\1\u00e4\1\uffff\1\50\1\uffff\2\50\1\uffff\1\u00e8"+
        "\2\uffff\1\u00e9\1\u00ea\1\50\2\uffff\1\50\1\u00ed\1\u00ee\3\50"+
        "\1\uffff\1\u00f2\2\50\1\uffff\4\50\1\uffff\1\50\1\u00fa\3\uffff"+
        "\2\50\2\uffff\1\50\1\u00fe\1\u00ff\3\uffff\1\u0100\1\u0101\2\uffff"+
        "\1\u0102\1\50\1\u0104\1\uffff\1\50\1\u0106\1\u0107\1\u0108\3\50"+
        "\1\uffff\1\u010c\1\u010d\1\50\5\uffff\1\u0110\1\uffff\1\50\3\uffff"+
        "\1\u0112\1\u0113\1\50\2\uffff\1\u0115\1\50\1\uffff\1\u0117\2\uffff"+
        "\1\u0118\1\uffff\1\50\2\uffff\1\50\1\u011b\1\uffff";
    static final String DFA22_eofS =
        "\u011c\uffff";
    static final String DFA22_minS =
        "\1\0\1\56\1\55\1\145\3\uffff\1\156\1\146\1\154\1\151\1\157\1\145"+
        "\2\uffff\1\57\1\72\2\uffff\1\141\1\160\1\uffff\1\162\1\146\1\150"+
        "\1\77\1\145\1\146\1\uffff\1\141\1\165\1\75\1\174\1\55\1\75\1\53"+
        "\1\157\1\uffff\1\157\6\uffff\2\43\1\uffff\1\56\4\uffff\1\146\1\166"+
        "\1\144\1\60\1\143\1\160\1\163\1\143\1\160\1\154\1\156\1\144\1\143"+
        "\7\uffff\1\155\1\154\1\145\1\160\1\171\1\141\2\60\1\145\2\uffff"+
        "\1\156\1\164\1\144\1\164\1\147\1\162\1\157\1\154\1\156\1\157\1\145"+
        "\15\uffff\1\162\1\164\3\uffff\1\60\2\uffff\1\151\1\60\2\145\1\144"+
        "\1\uffff\1\154\1\157\1\145\1\60\2\157\1\145\1\60\1\165\1\145\1\60"+
        "\1\160\1\144\1\154\1\143\1\145\1\143\1\145\1\60\1\161\1\154\2\uffff"+
        "\1\156\1\145\2\60\1\145\1\151\1\60\1\162\2\60\1\144\1\164\1\162"+
        "\2\60\1\156\1\uffff\2\146\1\145\1\165\1\162\1\60\1\146\1\uffff\1"+
        "\144\1\162\1\60\1\uffff\1\154\1\162\1\151\1\uffff\1\151\1\60\1\142"+
        "\1\150\3\60\1\uffff\1\165\1\163\2\60\1\uffff\1\154\1\uffff\1\162"+
        "\1\156\1\uffff\1\60\2\uffff\2\60\1\171\2\uffff\1\145\2\60\1\146"+
        "\1\144\1\164\1\uffff\1\60\1\151\1\164\1\uffff\1\145\1\144\1\166"+
        "\1\154\1\uffff\1\141\1\60\3\uffff\2\145\2\uffff\1\163\2\60\3\uffff"+
        "\2\60\2\uffff\1\60\1\145\1\60\1\uffff\1\156\3\60\2\145\1\143\1\uffff"+
        "\2\60\1\157\5\uffff\1\60\1\uffff\1\147\3\uffff\2\60\1\153\2\uffff"+
        "\1\60\1\154\1\uffff\1\60\2\uffff\1\60\1\uffff\1\151\2\uffff\1\142"+
        "\1\60\1\uffff";
    static final String DFA22_maxS =
        "\1\uffff\1\56\1\76\1\151\3\uffff\2\156\1\170\1\165\1\157\1\145\2"+
        "\uffff\1\75\1\72\2\uffff\1\157\1\160\1\uffff\1\171\1\162\1\150\1"+
        "\77\1\151\1\156\1\uffff\1\170\1\165\1\75\1\174\1\75\1\76\1\53\1"+
        "\157\1\uffff\1\157\6\uffff\2\145\1\uffff\1\56\4\uffff\1\146\1\166"+
        "\1\144\1\u00ff\1\143\1\160\1\163\1\144\1\160\1\154\1\156\1\144\1"+
        "\155\7\uffff\1\156\1\164\1\145\1\160\1\171\1\141\2\u00ff\1\145\2"+
        "\uffff\1\156\1\164\1\144\1\164\1\147\1\162\1\157\1\162\1\156\1\157"+
        "\1\145\15\uffff\1\162\1\164\3\uffff\1\145\2\uffff\1\151\1\u00ff"+
        "\2\145\1\144\1\uffff\1\154\1\157\1\145\1\u00ff\2\157\1\145\1\u00ff"+
        "\1\165\1\157\1\u00ff\1\160\1\144\1\154\1\143\1\145\1\143\1\145\1"+
        "\u00ff\1\161\1\154\2\uffff\1\156\1\145\2\u00ff\1\145\1\151\1\u00ff"+
        "\1\162\2\u00ff\1\144\1\164\1\162\2\u00ff\1\156\1\uffff\2\146\1\145"+
        "\1\165\1\162\1\u00ff\1\146\1\uffff\1\144\1\162\1\u00ff\1\uffff\1"+
        "\154\1\162\1\151\1\uffff\1\151\1\u00ff\1\142\1\150\3\u00ff\1\uffff"+
        "\1\165\1\163\2\u00ff\1\uffff\1\154\1\uffff\1\162\1\156\1\uffff\1"+
        "\u00ff\2\uffff\2\u00ff\1\171\2\uffff\1\145\2\u00ff\1\146\1\144\1"+
        "\164\1\uffff\1\u00ff\1\151\1\164\1\uffff\1\145\1\144\1\166\1\154"+
        "\1\uffff\1\141\1\u00ff\3\uffff\2\145\2\uffff\1\163\2\u00ff\3\uffff"+
        "\2\u00ff\2\uffff\1\u00ff\1\145\1\u00ff\1\uffff\1\156\3\u00ff\2\145"+
        "\1\143\1\uffff\2\u00ff\1\157\5\uffff\1\u00ff\1\uffff\1\147\3\uffff"+
        "\2\u00ff\1\153\2\uffff\1\u00ff\1\154\1\uffff\1\u00ff\2\uffff\1\u00ff"+
        "\1\uffff\1\151\2\uffff\1\142\1\u00ff\1\uffff";
    static final String DFA22_acceptS =
        "\4\uffff\1\4\1\5\1\6\6\uffff\1\22\1\23\2\uffff\1\27\1\30\2\uffff"+
        "\1\35\6\uffff\1\47\10\uffff\1\103\1\uffff\1\124\1\130\1\131\1\132"+
        "\1\133\1\134\2\uffff\1\140\1\uffff\1\1\1\41\1\113\1\2\15\uffff\1"+
        "\114\1\116\1\122\1\123\1\24\1\25\1\50\11\uffff\1\125\1\42\13\uffff"+
        "\1\115\1\64\1\67\1\66\1\70\1\72\1\73\1\117\1\71\1\120\1\121\1\112"+
        "\1\74\2\uffff\1\135\1\136\1\137\1\uffff\1\127\1\126\5\uffff\1\56"+
        "\25\uffff\1\101\1\60\20\uffff\1\104\7\uffff\1\52\3\uffff\1\63\3"+
        "\uffff\1\105\7\uffff\1\65\4\uffff\1\55\1\uffff\1\107\2\uffff\1\75"+
        "\1\uffff\1\77\1\100\3\uffff\1\102\1\111\6\uffff\1\12\3\uffff\1\16"+
        "\4\uffff\1\54\2\uffff\1\57\1\33\1\36\2\uffff\1\40\1\43\3\uffff\1"+
        "\76\1\106\1\110\2\uffff\1\7\1\10\3\uffff\1\13\7\uffff\1\44\3\uffff"+
        "\1\62\1\51\1\53\1\3\1\11\1\uffff\1\31\1\uffff\1\26\1\17\1\21\3\uffff"+
        "\1\37\1\45\2\uffff\1\14\1\uffff\1\61\1\32\1\uffff\1\46\1\uffff\1"+
        "\20\1\34\2\uffff\1\15";
    static final String DFA22_specialS =
        "\1\0\u011b\uffff}>";
    static final String[] DFA22_transitionS = {
            "\41\54\1\47\1\51\1\34\1\57\1\53\1\uffff\1\50\1\4\1\6\1\45\1"+
            "\43\1\5\1\2\1\1\1\37\1\56\3\55\6\56\1\20\1\25\1\41\1\17\1\42"+
            "\1\31\1\uffff\32\52\1\21\1\uffff\1\22\1\uffff\1\52\1\uffff\1"+
            "\33\1\35\1\23\1\3\1\11\1\12\2\50\1\10\2\50\1\32\1\13\1\46\1"+
            "\27\1\50\1\36\1\14\1\24\1\26\1\7\1\50\1\30\1\44\2\50\1\15\1"+
            "\40\1\16\1\uffff\42\54\37\uffff\27\52\1\uffff\7\52\30\50\1\uffff"+
            "\10\50\uff00\54",
            "\1\60",
            "\1\63\20\uffff\1\62",
            "\1\65\3\uffff\1\66",
            "",
            "",
            "",
            "\1\67",
            "\1\70\6\uffff\1\72\1\71",
            "\1\73\1\uffff\1\74\11\uffff\1\75",
            "\1\76\13\uffff\1\77",
            "\1\100",
            "\1\101",
            "",
            "",
            "\1\105\12\uffff\1\104\1\uffff\1\103\1\102",
            "\1\107",
            "",
            "",
            "\1\112\15\uffff\1\111",
            "\1\113",
            "",
            "\1\115\6\uffff\1\114",
            "\1\120\11\uffff\1\116\1\uffff\1\117",
            "\1\121",
            "\1\122",
            "\1\125\3\uffff\1\124",
            "\1\127\7\uffff\1\126",
            "",
            "\1\134\3\uffff\1\130\10\uffff\1\135\1\131\3\uffff\1\133\4\uffff"+
            "\1\132",
            "\1\136",
            "\1\137",
            "\1\141",
            "\1\144\16\uffff\1\143\1\145",
            "\1\150\1\147",
            "\1\152",
            "\1\154",
            "",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\156\14\uffff\12\56\13\uffff\1\160\37\uffff\1\160",
            "\1\156\14\uffff\12\161\13\uffff\1\160\37\uffff\1\160",
            "",
            "\1\162",
            "",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\3\50\1\167\11\50"+
            "\1\170\14\50\105\uffff\27\50\1\uffff\37\50\1\uffff\10\50",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\176\1\175",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083\11\uffff\1\u0084",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0085\1\u0086",
            "\1\u0087\6\uffff\1\u0089\1\u0088",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\4\50\1\u008e\25\50"+
            "\105\uffff\27\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u0091",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099\5\uffff\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "",
            "",
            "",
            "\12\161\13\uffff\1\160\37\uffff\1\160",
            "",
            "",
            "\1\u00a0",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\10\50\1\u00a8\21"+
            "\50\105\uffff\27\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00ae",
            "\1\u00b0\11\uffff\1\u00af",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\1\u00bf\31\50\105"+
            "\uffff\27\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00c1",
            "\1\u00c2",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00c4",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00dc",
            "\1\u00dd",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00eb",
            "",
            "",
            "\1\u00ec",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "",
            "",
            "\1\u00fb",
            "\1\u00fc",
            "",
            "",
            "\1\u00fd",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u0103",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u0105",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u010e",
            "",
            "",
            "",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\u010f\1\uffff\32\50\105\uffff"+
            "\27\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u0111",
            "",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u0114",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "\1\u0116",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            "",
            "\1\u0119",
            "",
            "",
            "\1\u011a",
            "\12\50\6\uffff\33\50\4\uffff\1\50\1\uffff\32\50\105\uffff\27"+
            "\50\1\uffff\37\50\1\uffff\10\50",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | RULE_ATOM | RULE_STRING | RULE_VARIABLE | RULE_SL_COMMENT | RULE_WS | RULE_BASED_INT | RULE_INT | RULE_EXT_INT | RULE_CHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                        s = -1;
                        if ( (LA22_0=='.') ) {s = 1;}

                        else if ( (LA22_0=='-') ) {s = 2;}

                        else if ( (LA22_0=='d') ) {s = 3;}

                        else if ( (LA22_0=='(') ) {s = 4;}

                        else if ( (LA22_0==',') ) {s = 5;}

                        else if ( (LA22_0==')') ) {s = 6;}

                        else if ( (LA22_0=='u') ) {s = 7;}

                        else if ( (LA22_0=='i') ) {s = 8;}

                        else if ( (LA22_0=='e') ) {s = 9;}

                        else if ( (LA22_0=='f') ) {s = 10;}

                        else if ( (LA22_0=='m') ) {s = 11;}

                        else if ( (LA22_0=='r') ) {s = 12;}

                        else if ( (LA22_0=='{') ) {s = 13;}

                        else if ( (LA22_0=='}') ) {s = 14;}

                        else if ( (LA22_0=='=') ) {s = 15;}

                        else if ( (LA22_0==':') ) {s = 16;}

                        else if ( (LA22_0=='[') ) {s = 17;}

                        else if ( (LA22_0==']') ) {s = 18;}

                        else if ( (LA22_0=='c') ) {s = 19;}

                        else if ( (LA22_0=='s') ) {s = 20;}

                        else if ( (LA22_0==';') ) {s = 21;}

                        else if ( (LA22_0=='t') ) {s = 22;}

                        else if ( (LA22_0=='o') ) {s = 23;}

                        else if ( (LA22_0=='w') ) {s = 24;}

                        else if ( (LA22_0=='?') ) {s = 25;}

                        else if ( (LA22_0=='l') ) {s = 26;}

                        else if ( (LA22_0=='a') ) {s = 27;}

                        else if ( (LA22_0=='#') ) {s = 28;}

                        else if ( (LA22_0=='b') ) {s = 29;}

                        else if ( (LA22_0=='q') ) {s = 30;}

                        else if ( (LA22_0=='/') ) {s = 31;}

                        else if ( (LA22_0=='|') ) {s = 32;}

                        else if ( (LA22_0=='<') ) {s = 33;}

                        else if ( (LA22_0=='>') ) {s = 34;}

                        else if ( (LA22_0=='+') ) {s = 35;}

                        else if ( (LA22_0=='x') ) {s = 36;}

                        else if ( (LA22_0=='*') ) {s = 37;}

                        else if ( (LA22_0=='n') ) {s = 38;}

                        else if ( (LA22_0=='!') ) {s = 39;}

                        else if ( (LA22_0=='\''||(LA22_0>='g' && LA22_0<='h')||(LA22_0>='j' && LA22_0<='k')||LA22_0=='p'||LA22_0=='v'||(LA22_0>='y' && LA22_0<='z')||(LA22_0>='\u00DF' && LA22_0<='\u00F6')||(LA22_0>='\u00F8' && LA22_0<='\u00FF')) ) {s = 40;}

                        else if ( (LA22_0=='\"') ) {s = 41;}

                        else if ( ((LA22_0>='A' && LA22_0<='Z')||LA22_0=='_'||(LA22_0>='\u00C0' && LA22_0<='\u00D6')||(LA22_0>='\u00D8' && LA22_0<='\u00DE')) ) {s = 42;}

                        else if ( (LA22_0=='%') ) {s = 43;}

                        else if ( ((LA22_0>='\u0000' && LA22_0<=' ')||(LA22_0>='\u007F' && LA22_0<='\u00A0')||(LA22_0>='\u0100' && LA22_0<='\uFFFF')) ) {s = 44;}

                        else if ( ((LA22_0>='1' && LA22_0<='3')) ) {s = 45;}

                        else if ( (LA22_0=='0'||(LA22_0>='4' && LA22_0<='9')) ) {s = 46;}

                        else if ( (LA22_0=='$') ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}