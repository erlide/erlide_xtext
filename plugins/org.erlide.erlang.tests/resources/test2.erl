-module(test1).

g(X) ->
	
	ok.

tc() -> {tk_sequence,
            {tk_struct,"IDL:omg.org/CosNotification/StructuredEvent:1.0",
                "StructuredEvent",
                [{"header",
                  {tk_struct,"IDL:omg.org/CosNotification/EventHeader:1.0",
                      "EventHeader",
                      [{"fixed_header",
                        {tk_struct,
                            "IDL:omg.org/CosNotification/FixedEventHeader:1.0",
                            "FixedEventHeader",
                            [{"event_type",
                              {tk_struct,
                                  "IDL:omg.org/CosNotification/EventType:1.0",
                                  "EventType",
                                  [{"domain_name",{tk_string,0}},
                                   {"type_name",{tk_string,0}}]}},
                             {"event_name",{tk_string,0}}]}},
                       {"variable_header",
                        {tk_sequence,
                            {tk_struct,
                                "IDL:omg.org/CosNotification/Property:1.0",
                                "Property",
                                [{"name",{tk_string,0}},{"value",tk_any}]},
                            0}}]}},
                 {"filterable_data",
                  {tk_sequence,
                      {tk_struct,"IDL:omg.org/CosNotification/Property:1.0",
                          "Property",
                          [{"name",{tk_string,0}},{"value",tk_any}]},
                      0}},
                 {"remainder_of_body",tk_any}]},
            0}.


  