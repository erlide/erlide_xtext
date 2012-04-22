-module(test1).
%-export([f/1]).
f(X) ->
	3 = 1 + 2 * 4,
	3 = 1 * 2 + 4,
	3 = 1 * (2 + 4),
	3 = 1 + 2 + 4,
	
	X = X + 14 * erlang:now(),
	{ok,"X
Y"}.
-define(X(S), y).
-define(Y(S), r).
h(X) ->
	?X:?Y(3),
	try X catch error:X->X end,
	<<4:4, (4/2)>>, X=X=X,
	fun(X, 2) -> X end,
	ok.
