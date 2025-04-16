# Projeto de Cálculos Matemáticos em Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/Swing-UI-blue?style=for-the-badge)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

Bem-vindo ao repositório do **Projeto de Cálculos Matemáticos em Java**!  
Desenvolvido como parte da disciplina de **Programação Orientada a Objetos** no curso de **Ciência da Computação** da **UNESC**.

Este projeto oferece uma aplicação com **interface gráfica interativa** para diversos cálculos matemáticos e um **gerador de senhas seguras** — ideal para estudantes, profissionais e entusiastas da programação.

---

## ✨ Funcionalidades

A interface, desenvolvida com **Java Swing**, é organizada em **painéis interativos**, cada um dedicado a uma funcionalidade específica:

- ✅ Aplicar desconto percentual  
- ✅ Aumentar um valor por uma porcentagem  
- ✅ Descobrir quanto uma porcentagem representa de um total  
- ✅ Calcular a porcentagem que uma parte representa do todo  
- ✅ Determinar a porcentagem de desconto entre dois valores  
- ✅ Calcular variação percentual (delta)  
- ✅ Estimar o valor original antes de um desconto  
- ✅ Resolver regra de três simples  
- ✅ Gerar senhas seguras com configurações personalizadas  

Cada painel oferece campos dinâmicos e resultados **em tempo real**.

---

## 🛠️ Tecnologias e Conceitos

- **Java 8+**
- **Java Swing** (interface gráfica)
- **Programação Orientada a Objetos**
- **Herança** (`mathView` estende `JFrame`)
- **Classe utilitária estática** (`mathUtils`)
- **Testes manuais** (`MathUtilsTest`)

---

## 📁 Estrutura do Projeto

```
unesc-math-java-project/
│
├── view/
│   └── mathView.java         # Interface gráfica principal
│
├── utils/
│   ├── mathUtils.java        # Lógica dos cálculos e gerador de senhas
│   └── MathUtilsTest.java    # Testes manuais dos métodos utilitários
```

---

## 📌 Fórmulas Utilizadas

| Cálculo                                       | Fórmula                                                                 |
|----------------------------------------------|-------------------------------------------------------------------------|
| Desconto Percentual                          | `final = valor - (valor * (desc / 100))`                               |
| Aumento Percentual                           | `final = valor * (1 + (aumento / 100))`                                |
| Parte de um Total                            | `parte = (total * porcentagem) / 100`                                  |
| Representação Percentual                     | `porcentagem = (parte / total) * 100`                                  |
| Porcentagem de Desconto                      | `desc = ((original - final) / original) * 100`                         |
| Variação Percentual                          | `delta = ((final - inicial) / inicial) * 100`                          |
| Valor Original Antes do Desconto             | `original = final / (1 - (desc / 100))`                                |
| Regra de Três Simples                        | `r2 = (b * r1) / a`                                                     |
| Gerador de Senhas                            | Letras (aA), números (0-9) e símbolos, com opções personalizadas       |

---

## 🔐 Gerador de Senhas Seguras

Gera senhas aleatórias com:

- Letras maiúsculas e minúsculas  
- Números  
- Símbolos  
- Comprimento personalizável  

> Exemplo: `"Kj#9mPx$2nLq"` (12 caracteres com todos os tipos ativados)

**Regras:**

- Pelo menos um tipo de caractere deve ser selecionado
- O tamanho deve suportar os tipos escolhidos

---

## 🚀 Como Executar

### Pré-requisitos

- JDK 8 ou superior
- IDE Java (Eclipse, IntelliJ) ou terminal com `javac`

### Passos para execução:

```bash
# Clone o repositório
git clone https://github.com/ckzwebber/unesc-math-java-project

# Acesse o diretório do projeto
cd unesc-math-java-project

# Compile os arquivos
javac view/mathView.java utils/mathUtils.java utils/MathUtilsTest.java

# Execute a aplicação
java view.mathView

# (Opcional) Execute os testes
java utils.MathUtilsTest
```

---

## 👤 Autor

Desenvolvido por [Carlos Miguel Webber Miguel](https://www.linkedin.com/in/cmiguelwm/)  
Entre em contato para dúvidas, sugestões ou colaborações!

---

## 📄 Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).
