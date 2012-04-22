form -> attribute dot : '$1'.
form -> function dot : '$1'.
form -> rule dot : '$1'.

attribute -> '-' atom attr_val               : build_attribute('$2', '$3').
attribute -> '-' atom typed_attr_val         : build_typed_attribute('$2','$3').
attribute -> '-' atom '(' typed_attr_val ')' : build_typed_attribute('$2','$4').
attribute -> '-' 'spec' type_spec            : build_type_spec('$2', '$3').

type_spec -> spec_fun type_sigs : {'$1', '$2'}.
type_spec -> '(' spec_fun type_sigs ')' : {'$2', '$3'}.

spec_fun ->                           atom : '$1'.
spec_fun ->                  atom ':' atom : {'$1', '$3'}.
%% The following two are retained only for backwards compatibility;
%% they are not part of the EEP syntax and should be removed.
spec_fun ->          atom '/' integer '::' : {'$1', '$3'}.
spec_fun -> atom ':' atom '/' integer '::' : {'$1', '$3', '$5'}.

typed_attr_val -> expr ',' typed_record_fields : {typed_record, '$1', '$3'}.
typed_attr_val -> expr '::' top_type           : {type_def, '$1', '$3'}.

typed_record_fields -> '{' typed_exprs '}' : {tuple, ?line('$1'), '$2'}.

typed_exprs -> typed_expr                 : ['$1'].
typed_exprs -> typed_expr ',' typed_exprs : ['$1'|'$3'].
typed_exprs -> expr ',' typed_exprs       : ['$1'|'$3'].
typed_exprs -> typed_expr ',' exprs       : ['$1'|'$3'].

typed_expr -> expr '::' top_type          : {typed,'$1','$3'}.

type_sigs -> type_sig                     : ['$1'].
type_sigs -> type_sig ';' type_sigs       : ['$1'|'$3'].

type_sig -> fun_type                      : '$1'.
type_sig -> fun_type 'when' type_guards   : {type, ?line('$1'), bounded_fun,
                                             ['$1','$3']}.

type_guards -> type_guard                 : ['$1'].
type_guards -> type_guard ',' type_guards : ['$1'|'$3'].

type_guard -> atom '(' top_types ')'      : {type, ?line('$1'), constraint,
                                             ['$1', '$3']}.
type_guard -> var '::' top_type           : build_def('$1', '$3').

top_types -> top_type                     : ['$1'].
top_types -> top_type ',' top_types       : ['$1'|'$3'].

top_type -> var '::' top_type_100         : {ann_type, ?line('$1'), ['$1','$3']}.
top_type -> top_type_100                  : '$1'.

top_type_100 -> type_200                  : '$1'.
top_type_100 -> type_200 '|' top_type_100 : lift_unions('$1','$3').

type_200 -> type_300 '..' type_300        : {type, ?line('$1'), range,
                                             [skip_paren('$1'),
                                              skip_paren('$3')]}.
type_200 -> type_300                      : '$1'.

type_300 -> type_300 add_op type_400      : ?mkop2(skip_paren('$1'),
                                                   '$2', skip_paren('$3')).
type_300 -> type_400                      : '$1'.

type_400 -> type_400 mult_op type_500     : ?mkop2(skip_paren('$1'),
                                                   '$2', skip_paren('$3')).
type_400 -> type_500                      : '$1'.

type_500 -> prefix_op type                : ?mkop1('$1', skip_paren('$2')).
type_500 -> type                          : '$1'.

type -> '(' top_type ')'                  : {paren_type, ?line('$2'), ['$2']}.
type -> var                               : '$1'.
type -> atom                              : '$1'.
type -> atom '(' ')'                      : build_gen_type('$1').
type -> atom '(' top_types ')'            : {type, ?line('$1'),
                                             normalise('$1'), '$3'}.
type -> atom ':' atom '(' ')'             : {remote_type, ?line('$1'),
                                             ['$1', '$3', []]}.
type -> atom ':' atom '(' top_types ')'   : {remote_type, ?line('$1'),
                                             ['$1', '$3', '$5']}.
type -> '[' ']'                           : {type, ?line('$1'), nil, []}.
type -> '[' top_type ']'                  : {type, ?line('$1'), list, ['$2']}.
type -> '[' top_type ',' '...' ']'        : {type, ?line('$1'),
                                             nonempty_list, ['$2']}.
type -> '{' '}'                           : {type, ?line('$1'), tuple, []}.
type -> '{' top_types '}'                 : {type, ?line('$1'), tuple, '$2'}.
type -> '#' atom '{' '}'                  : {type, ?line('$1'), record, ['$2']}.
type -> '#' atom '{' field_types '}'      : {type, ?line('$1'),
                                             record, ['$2'|'$4']}.
type -> binary_type                       : '$1'.
type -> integer                           : '$1'.
type -> 'fun' '(' ')'                     : {type, ?line('$1'), 'fun', []}.
type -> 'fun' '(' fun_type_100 ')'        : '$3'.

fun_type_100 -> '(' '...' ')' '->' top_type
                                          : {type, ?line('$1'), 'fun',
                                             [{type, ?line('$1'), any}, '$5']}.
fun_type_100 -> fun_type                  : '$1'.

fun_type -> '(' ')' '->' top_type  : {type, ?line('$1'), 'fun',
                                      [{type, ?line('$1'), product, []}, '$4']}.
fun_type -> '(' top_types ')' '->' top_type
                                   : {type, ?line('$1'), 'fun',
                                      [{type, ?line('$1'), product, '$2'},'$5']}.

field_types -> field_type                 : ['$1'].
field_types -> field_type ',' field_types : ['$1'|'$3'].

field_type -> atom '::' top_type          : {type, ?line('$1'), field_type,
                                             ['$1', '$3']}.

binary_type -> '<<' '>>'                  : {type, ?line('$1'),binary,
					     [abstract(0, ?line('$1')),
					      abstract(0, ?line('$1'))]}.
binary_type -> '<<' bin_base_type '>>'    : {type, ?line('$1'),binary,
					     ['$2', abstract(0, ?line('$1'))]}.
binary_type -> '<<' bin_unit_type '>>'    : {type, ?line('$1'),binary,
                                             [abstract(0, ?line('$1')), '$2']}.
binary_type -> '<<' bin_base_type ',' bin_unit_type '>>'
                                    : {type, ?line('$1'), binary, ['$2', '$4']}.

bin_base_type -> var ':' type          : build_bin_type(['$1'], '$3').

bin_unit_type -> var ':' var '*' type  : build_bin_type(['$1', '$3'], '$5').

attr_val -> expr                     : ['$1'].
attr_val -> expr ',' exprs           : ['$1' | '$3'].
attr_val -> '(' expr ',' exprs ')'   : ['$2' | '$4'].

function -> function_clauses : build_function('$1').

function_clauses -> function_clause : ['$1'].
function_clauses -> function_clause ';' function_clauses : ['$1'|'$3'].

function_clause -> atom clause_args clause_guard clause_body :
	{clause,?line('$1'),element(3, '$1'),'$2','$3','$4'}.


clause_args -> argument_list : element(1, '$1').

clause_guard -> 'when' guard : '$2'.
clause_guard -> '$empty' : [].

clause_body -> '->' exprs: '$2'.


expr -> 'catch' expr : {'catch',?line('$1'),'$2'}.
expr -> expr_100 : '$1'.

expr_100 -> expr_150 '=' expr_100 : {match,?line('$2'),'$1','$3'}.
expr_100 -> expr_150 '!' expr_100 : ?mkop2('$1', '$2', '$3').
expr_100 -> expr_150 : '$1'.

expr_150 -> expr_160 'orelse' expr_150 : ?mkop2('$1', '$2', '$3').
expr_150 -> expr_160 : '$1'.

expr_160 -> expr_200 'andalso' expr_160 : ?mkop2('$1', '$2', '$3').
expr_160 -> expr_200 : '$1'.

expr_200 -> expr_300 comp_op expr_300 :
	?mkop2('$1', '$2', '$3').
expr_200 -> expr_300 : '$1'.

expr_300 -> expr_400 list_op expr_300 :
	?mkop2('$1', '$2', '$3').
expr_300 -> expr_400 : '$1'.

expr_400 -> expr_400 add_op expr_500 :
	?mkop2('$1', '$2', '$3').
expr_400 -> expr_500 : '$1'.

expr_500 -> expr_500 mult_op expr_600 :
	?mkop2('$1', '$2', '$3').
expr_500 -> expr_600 : '$1'.

expr_600 -> prefix_op expr_700 :
	?mkop1('$1', '$2').
expr_600 -> expr_700 : '$1'.

expr_700 -> function_call : '$1'.
expr_700 -> record_expr : '$1'.
expr_700 -> expr_800 : '$1'.

expr_800 -> expr_900 ':' expr_max :
	{remote,?line('$2'),'$1','$3'}.
expr_800 -> expr_900 : '$1'.

expr_900 -> '.' atom :
	{record_field,?line('$1'),{atom,?line('$1'),''},'$2'}.
expr_900 -> expr_900 '.' atom :
	{record_field,?line('$2'),'$1','$3'}.
expr_900 -> expr_max : '$1'.

expr_max -> var : '$1'.
expr_max -> atomic : '$1'.
expr_max -> list : '$1'.
expr_max -> binary : '$1'.
expr_max -> list_comprehension : '$1'.
expr_max -> binary_comprehension : '$1'.
expr_max -> tuple : '$1'.
%%expr_max -> struct : '$1'.
expr_max -> '(' expr ')' : '$2'.
expr_max -> 'begin' exprs 'end' : {block,?line('$1'),'$2'}.
expr_max -> if_expr : '$1'.
expr_max -> case_expr : '$1'.
expr_max -> receive_expr : '$1'.
expr_max -> fun_expr : '$1'.
expr_max -> try_expr : '$1'.
expr_max -> query_expr : '$1'.


list -> '[' ']' : {nil,?line('$1')}.
list -> '[' expr tail : {cons,?line('$1'),'$2','$3'}.

tail -> ']' : {nil,?line('$1')}.
tail -> '|' expr ']' : '$2'.
tail -> ',' expr tail : {cons,?line('$2'),'$2','$3'}.


binary -> '<<' '>>' : {bin,?line('$1'),[]}.
binary -> '<<' bin_elements '>>' : {bin,?line('$1'),'$2'}.

bin_elements -> bin_element : ['$1'].
bin_elements -> bin_element ',' bin_elements : ['$1'|'$3'].

bin_element -> bit_expr opt_bit_size_expr opt_bit_type_list :
	{bin_element,?line('$1'),'$1','$2','$3'}.

bit_expr -> prefix_op expr_max : ?mkop1('$1', '$2').
bit_expr -> expr_max : '$1'.

opt_bit_size_expr -> ':' bit_size_expr : '$2'.
opt_bit_size_expr -> '$empty' : default.

opt_bit_type_list -> '/' bit_type_list : '$2'.
opt_bit_type_list -> '$empty' : default.

bit_type_list -> bit_type '-' bit_type_list : ['$1' | '$3'].
bit_type_list -> bit_type : ['$1'].

bit_type -> atom             : element(3,'$1').
bit_type -> atom ':' integer : { element(3,'$1'), element(3,'$3') }.

bit_size_expr -> expr_max : '$1'.


list_comprehension -> '[' expr '||' lc_exprs ']' :
	{lc,?line('$1'),'$2','$4'}.
binary_comprehension -> '<<' binary '||' lc_exprs '>>' :
	{bc,?line('$1'),'$2','$4'}.
lc_exprs -> lc_expr : ['$1'].
lc_exprs -> lc_expr ',' lc_exprs : ['$1'|'$3'].

lc_expr -> expr : '$1'.
lc_expr -> expr '<-' expr : {generate,?line('$2'),'$1','$3'}.
lc_expr -> binary '<=' expr : {b_generate,?line('$2'),'$1','$3'}.

tuple -> '{' '}' : {tuple,?line('$1'),[]}.
tuple -> '{' exprs '}' : {tuple,?line('$1'),'$2'}.


%%struct -> atom tuple :
%%	{struct,?line('$1'),element(3, '$1'),element(3, '$2')}.


%% N.B. This is called from expr_700.
%% N.B. Field names are returned as the complete object, even if they are
%% always atoms for the moment, this might change in the future.

record_expr -> '#' atom '.' atom :
	{record_index,?line('$1'),element(3, '$2'),'$4'}.
record_expr -> '#' atom record_tuple :
	{record,?line('$1'),element(3, '$2'),'$3'}.
record_expr -> expr_max '#' atom '.' atom :
	{record_field,?line('$2'),'$1',element(3, '$3'),'$5'}.
record_expr -> expr_max '#' atom record_tuple :
	{record,?line('$2'),'$1',element(3, '$3'),'$4'}.
record_expr -> record_expr '#' atom '.' atom :
	{record_field,?line('$2'),'$1',element(3, '$3'),'$5'}.
record_expr -> record_expr '#' atom record_tuple :
	{record,?line('$2'),'$1',element(3, '$3'),'$4'}.

record_tuple -> '{' '}' : [].
record_tuple -> '{' record_fields '}' : '$2'.

record_fields -> record_field : ['$1'].
record_fields -> record_field ',' record_fields : ['$1' | '$3'].

record_field -> var '=' expr : {record_field,?line('$1'),'$1','$3'}.
record_field -> atom '=' expr : {record_field,?line('$1'),'$1','$3'}.

%% N.B. This is called from expr_700.

function_call -> expr_800 argument_list :
	{call,?line('$1'),'$1',element(1, '$2')}.


if_expr -> 'if' if_clauses 'end' : {'if',?line('$1'),'$2'}.

if_clauses -> if_clause : ['$1'].
if_clauses -> if_clause ';' if_clauses : ['$1' | '$3'].

if_clause -> guard clause_body :
	{clause,?line(hd(hd('$1'))),[],'$1','$2'}.


case_expr -> 'case' expr 'of' cr_clauses 'end' :
	{'case',?line('$1'),'$2','$4'}.

cr_clauses -> cr_clause : ['$1'].
cr_clauses -> cr_clause ';' cr_clauses : ['$1' | '$3'].

cr_clause -> expr clause_guard clause_body :
	{clause,?line('$1'),['$1'],'$2','$3'}.

receive_expr -> 'receive' cr_clauses 'end' :
	{'receive',?line('$1'),'$2'}.
receive_expr -> 'receive' 'after' expr clause_body 'end' :
	{'receive',?line('$1'),[],'$3','$4'}.
receive_expr -> 'receive' cr_clauses 'after' expr clause_body 'end' :
	{'receive',?line('$1'),'$2','$4','$5'}.


fun_expr -> 'fun' atom '/' integer :
	{'fun',?line('$1'),{function,element(3, '$2'),element(3, '$4')}}.
fun_expr -> 'fun' atom ':' atom '/' integer :
	{'fun',?line('$1'),{function,element(3, '$2'),element(3, '$4'),element(3,'$6')}}.
fun_expr -> 'fun' fun_clauses 'end' :
	build_fun(?line('$1'), '$2').

fun_clauses -> fun_clause : ['$1'].
fun_clauses -> fun_clause ';' fun_clauses : ['$1' | '$3'].

fun_clause -> argument_list clause_guard clause_body :
	{Args,Pos} = '$1',
	{clause,Pos,'fun',Args,'$2','$3'}.

try_expr -> 'try' exprs 'of' cr_clauses try_catch :
	build_try(?line('$1'),'$2','$4','$5').
try_expr -> 'try' exprs try_catch :
	build_try(?line('$1'),'$2',[],'$3').

try_catch -> 'catch' try_clauses 'end' :
	{'$2',[]}.
try_catch -> 'catch' try_clauses 'after' exprs 'end' :
	{'$2','$4'}.
try_catch -> 'after' exprs 'end' :
	{[],'$2'}.

try_clauses -> try_clause : ['$1'].
try_clauses -> try_clause ';' try_clauses : ['$1' | '$3'].

try_clause -> expr clause_guard clause_body :
	L = ?line('$1'),
	{clause,L,[{tuple,L,[{atom,L,throw},'$1',{var,L,'_'}]}],'$2','$3'}.
try_clause -> atom ':' expr clause_guard clause_body :
	L = ?line('$1'),
	{clause,L,[{tuple,L,['$1','$3',{var,L,'_'}]}],'$4','$5'}.
try_clause -> var ':' expr clause_guard clause_body :
	L = ?line('$1'),
	{clause,L,[{tuple,L,['$1','$3',{var,L,'_'}]}],'$4','$5'}.

query_expr -> 'query' list_comprehension 'end' :
	{'query',?line('$1'),'$2'}.


argument_list -> '(' ')' : {[],?line('$1')}.
argument_list -> '(' exprs ')' : {'$2',?line('$1')}.


exprs -> expr : ['$1'].
exprs -> expr ',' exprs : ['$1' | '$3'].

guard -> exprs : ['$1'].
guard -> exprs ';' guard : ['$1'|'$3'].

atomic -> char : '$1'.
atomic -> integer : '$1'.
atomic -> float : '$1'.
atomic -> atom : '$1'.
atomic -> strings : '$1'.

strings -> string : '$1'.
strings -> string strings :
	{string,?line('$1'),element(3, '$1') ++ element(3, '$2')}.

prefix_op -> '+' : '$1'.
prefix_op -> '-' : '$1'.
prefix_op -> 'bnot' : '$1'.
prefix_op -> 'not' : '$1'.

mult_op -> '/' : '$1'.
mult_op -> '*' : '$1'.
mult_op -> 'div' : '$1'.
mult_op -> 'rem' : '$1'.
mult_op -> 'band' : '$1'.
mult_op -> 'and' : '$1'.

add_op -> '+' : '$1'.
add_op -> '-' : '$1'.
add_op -> 'bor' : '$1'.
add_op -> 'bxor' : '$1'.
add_op -> 'bsl' : '$1'.
add_op -> 'bsr' : '$1'.
add_op -> 'or' : '$1'.
add_op -> 'xor' : '$1'.

list_op -> '++' : '$1'.
list_op -> '--' : '$1'.

comp_op -> '==' : '$1'.
comp_op -> '/=' : '$1'.
comp_op -> '=<' : '$1'.
comp_op -> '<' : '$1'.
comp_op -> '>=' : '$1'.
comp_op -> '>' : '$1'.
comp_op -> '=:=' : '$1'.
comp_op -> '=/=' : '$1'.

rule -> rule_clauses : build_rule('$1').

rule_clauses -> rule_clause : ['$1'].
rule_clauses -> rule_clause ';' rule_clauses : ['$1'|'$3'].

rule_clause -> atom clause_args clause_guard rule_body :
	{clause,?line('$1'),element(3, '$1'),'$2','$3','$4'}.

rule_body -> ':-' lc_exprs: '$2'.

