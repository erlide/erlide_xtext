-module(test3).

-record(rec, {x, y}).
-define(X, "hej).").

g() ->
	16#00001100,
	ok.

u(G) ->
	X = G#rec{}#rec{},
	ok.
