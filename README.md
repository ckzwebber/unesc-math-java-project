# Projeto de Cálculos Matemáticos em Java

Bem-vindo ao repositório do **Projeto de Cálculos Matemáticos em Java**!  
Este projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos** do curso de **Ciência da Computação** da **Universidade do Extremo Sul Catarinense (UNESC)**.

O objetivo é criar um programa com **interface gráfica** que realiza diversos cálculos matemáticos úteis, além de um **gerador de senhas seguras**.

---

## Descrição do Projeto

O programa oferece uma interface gráfica amigável construída com **Java Swing**, permitindo ao usuário realizar os seguintes cálculos e funcionalidades:

- Aplicar desconto percentual em um valor
- Incrementar um valor por uma porcentagem
- Calcular quanto uma porcentagem representa de um total
- Calcular a representação percentual de uma parte em relação ao total
- Determinar a porcentagem de desconto
- Calcular a variação percentual (delta)
- Encontrar o valor original antes de um desconto
- Regra de três simples
- Gerador de senhas seguras com opções de caracteres

Cada funcionalidade é apresentada em um **painel dedicado** na interface, com campos de entrada e resultados atualizados em tempo real.

---

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Biblioteca de Interface:** Swing

### Conceitos Aplicados

- Programação Orientada a Objetos
- Herança (`mathView` estende `JFrame`)
- Classe utilitária estática (`mathUtils`)
- Testes (`MathUtilsTest`)

---

## Estrutura do Projeto

O código está organizado em pacotes para facilitar a manutenção e compreensão:

- `view/`: Contém a classe `mathView`, responsável pela interface gráfica.
- `utils/`:
  - `mathUtils`: Classe estática com as fórmulas e lógica dos cálculos.
  - `MathUtilsTest`: Classe de testes para verificar as funcionalidades de `mathUtils`.

---

## Classes Principais

- **`mathView`**: Constrói a interface gráfica com painéis interativos e utiliza `DocumentListener` para atualizar os cálculos em tempo real.
- **`mathUtils`**: Implementa os métodos estáticos para os cálculos e o gerador de senhas.
- **`MathUtilsTest`**: Contém testes manuais para validar os métodos de `mathUtils`.

---

## Funcionalidades e Fórmulas

### 1. Aplicar Desconto Percentual

**Fórmula:**  
`valorFinal = valorInicial - (valorInicial * (desconto / 100))`  
**Exemplo:**  
`100 com 20% de desconto = 80`

### 2. Incrementar um Valor por uma Porcentagem

**Fórmula:**  
`valorFinal = valorInicial * (1 + (aumento / 100))`  
**Exemplo:**  
`100 com 10% de aumento = 110`

### 3. Calcular Quanto uma Porcentagem Representa de um Total

**Fórmula:**  
`parte = (total * porcentagem) / 100`  
**Exemplo:**  
`25% de 200 = 50`

### 4. Calcular a Representação Percentual de uma Parte

**Fórmula:**  
`porcentagem = (parte / total) * 100`  
**Exemplo:**  
`50 de 200 = 25%`

### 5. Determinar a Porcentagem de Desconto

**Fórmula:**  
`desconto = ((valorOriginal - valorComDesconto) / valorOriginal) * 100`  
**Exemplo:**  
`Original 100, com desconto 80 = 20%`

### 6. Variação Percentual (Delta)

**Fórmula:**  
`diferenca = ((valorFinal - valorInicial) / valorInicial) * 100`  
**Exemplo:**  
`De 100 para 120 = 20%`

### 7. Encontrar o Valor Original Antes de um Desconto

**Fórmula:**  
`valorOriginal = valorComDesconto / (1 - (desconto / 100))`  
**Exemplo:**  
`80 com 20% de desconto, original = 100`

### 8. Regra de Três Simples

**Fórmula:**  
`r2 = (b * r1) / a`  
**Exemplo:**  
`Se a = 5, b = 10, r1 = 15, então r2 = 30`

### 9. Gerador de Senha

**Descrição:**  
Gera senhas seguras com opções de caracteres (maiúsculas, minúsculas, números, símbolos) e tamanho definido.

**Regras:**

- Pelo menos um tipo de caractere deve ser selecionado.
- O tamanho mínimo da senha deve suportar os tipos escolhidos.

**Exemplo:**  
`"Kj#9mPx$2nLq"` (12 caracteres, todos os tipos)

---

## ▶Como Executar o Projeto

### Requisitos

- Java Development Kit (JDK) instalado (versão 8 ou superior)
- Um ambiente de desenvolvimento (como **Eclipse** ou **IntelliJ IDEA**) ou o compilador Java via linha de comando

### Passos

```bash
# Clone o repositório
git clone https://github.com/ckzwebber/unesc-math-java-project

# Acesse o diretório do projeto
cd unesc-math-java-project

# Compile os arquivos
javac view/mathView.java utils/mathUtils.java utils/MathUtilsTest.java

# Execute o programa
java view.mathView

# Execute os testes
java utils.MathUtilsTest
```

---

## Contato

Para mais informações ou dúvidas, entre em contato comigo pelo meu [LinkedIn](https://www.linkedin.com/in/cmiguelwm/).  
Até mais! 👋
