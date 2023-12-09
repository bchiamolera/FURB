% FATOS
homem( alberto ).
homem( deivid ).

mulher( barbara ).
mulher( carol ).
mulher( ester ).

% quadrimestre( nome, quadrimestre, qtd_atendimentos, qtd_vendas,
% aval_posi, aval_nega ).
quadrimestre( alberto, 1, 40, 12, 18, 22 ).
quadrimestre( alberto, 2, 16, 0, 4, 12 ).
quadrimestre( alberto, 3, 10, 0, 5, 5 ).

quadrimestre( barbara, 1, 25, 25, 24, 1 ).
quadrimestre( barbara, 2, 32, 24, 20, 2 ).
quadrimestre( barbara, 3, 18, 10, 12, 6 ).

quadrimestre( carol, 1, 48, 30, 25, 23 ).
quadrimestre( carol, 2, 20, 10, 15, 5 ).
quadrimestre( carol, 3, 21, 16, 18, 3 ).

quadrimestre( deivid, 1, 15, 10, 12, 3 ).
quadrimestre( deivid, 2, 30, 30, 20, 10 ).
quadrimestre( deivid, 3, 25, 19, 18, 7 ).

quadrimestre( ester, 1, 8, 0, 8, 0).
quadrimestre( ester, 2, 18, 2, 2, 16).
quadrimestre( ester, 3, 20, 12, 10, 10 ).

% REGRAS

bonificacao1(X,S) :- quadrimestre(X,S,A,V,_P,_N), A=V.

bonificacao2(X,S) :- bonificacao1(X,S), quadrimestre(X,S,_A,_V,P,N), ( P / ( P + N) >=  0.8).

notificacao(X,S)  :- quadrimestre(X,S,A,V,P,N), (( N / ( P + N) >=  0.5); (V / (A + V) =< 0.25 )).

demitido(X,S1,S2) :-  quadrimestre(X,S1,_A1,V1,_P1,_N1), quadrimestre(X,S2,_A2,V2,_P2,_N2), V1=0, V2=0, S1 \= S2.










