package org.erlide.scoping;

public enum ErlangLinkCategory {
    // @formatter:off
	NONE,
	MODULE,
	FUNCTION_CALL_LOCAL,
	FUNCTION_CALL_REMOTE,
    FUNCTION_REF_LOCAL,
    FUNCTION_REF_REMOTE,
	RECORD,
	RECORD_FIELD
	// @formatter:on
}
