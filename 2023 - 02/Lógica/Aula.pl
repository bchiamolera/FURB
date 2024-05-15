% -> Comentários

% Fatos

homem(mário).
homem(pedro).
homem(gabriel).
homem(joao).

mulher(marina).
mulher(sara).
mulher(maria).
mulher(joana).

genitor(mário,sara).
genitor(marina,sara).
genitor(pedro,joao).
genitor(maria,joana).


% Regras

pai(X,Y):- homem(X),genitor(X,Y).
pai(X) :- pai(X,_).

mae(X,Y) :- mulher(X),genitor(X,Y).
mae(X) :- mae(X,_).
