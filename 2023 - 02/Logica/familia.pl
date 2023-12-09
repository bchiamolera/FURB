% base de fatos e regras para relacoes de parentesco editada em: 25/11/2019

/* ---------------------------------------------------
   Fatos: homem( X ) e mulher( X )
   -------------------------------------------------- */

homem( mario ).
homem( pedro ).
homem( jose ).
homem( samuel ).
homem( fabio ).
homem( marcio ).
homem( gabriel ).
homem( jean ).

mulher( marina ).
mulher( paula ).
mulher( marta ).
mulher( sara).
mulher( teresa ).
mulher( joana ).
mulher( tatiana ).
mulher( patricia ).
mulher( claudia ).


/* ---------------------------------------------------
   Fatos: genitor(pai/mae, filho/filha)
   --------------------------------------------------- */

genitor( pedro, fabio ).	genitor( paula, fabio ).
genitor( pedro, teresa ).	genitor( paula, teresa ).
genitor( fabio, tatiana ).	genitor( sara, tatiana ).
genitor( fabio, jean ).		genitor( sara, jean ).
genitor( jean,  claudia ).	genitor( patricia, claudia ).
genitor( mario, samuel ).       genitor( marina, samuel ).
genitor( mario, jose ).         genitor( marina, jose ).
genitor( mario, sara ).         genitor( marina, sara ).
genitor( marta, joana ).        genitor( jose, joana).
genitor( marta, marcio ).       genitor( jose, marcio ).
genitor( marta, gabriel ).      genitor( jose, gabriel ).


/* ---------------------------------------------------
   Regras
   --------------------------------------------------- */
pai(X,Y) :- genitor(X,Y), homem(X).
