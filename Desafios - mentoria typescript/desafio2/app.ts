// Como podemos melhorar o esse código usando TS? 
/*
let pessoa1 = {};
pessoa1.nome = "maria";
pessoa1.idade = 29;
pessoa1.profissao = "atriz"

let pessoa2 = {}
pessoa2.nome = "roberto";
pessoa2.idade = 19;
pessoa2.profissao = "Padeiro";

let pessoa3 = {
    nome: "laura",
    idade: "32",
    profissao: "Atriz"
};

let pessoa4 = {
    nome = "carlos",
    idade = 19,
    profissao = "padeiro"
}
*/

//RESPOSTA

 //percebemos que profissões identicas encontram-se com diferentes formas de escrita para resolver
 //isto podemos utilizar o tipo 'enum' que nos sugere nomes previamente cadastrados e criamos uma 
 //interface 'Pessoa' para que os objetos 'pessoaX' sigam os tipos definidos nesta interface

 enum Profissao{
     Atriz,
     Padeiro
 }

 interface Pessoa{
    nome: string,
    idade: number,
    profissao: Profissao
}

let pessoa1: Pessoa = {
    nome: "maria",
    idade:  29,
    profissao: Profissao.Atriz,
}

let pessoa2: Pessoa = {
    nome: "roberto",
    idade: 19,
    profissao: Profissao.Padeiro
}

let pessoa3: Pessoa = {
    nome: "laura",
    idade: 32,
    profissao: Profissao.Atriz
};

let pessoa4: Pessoa = {
    nome: "carlos",
    idade: 19,
    profissao: Profissao.Padeiro
}

//console.log(pessoa1.nome, pessoa2.idade, pessoa3.nome, pessoa4.profissao)