package org.erlide.erlang.parserdb;

import java.util.List;

import com.google.common.collect.Lists;

public class ModuleInfo {
    String path;
    List<FormInfo> forms = Lists.newArrayList();
}
