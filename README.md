
# API-de-gerenciamento-de-tarefas

Uma API que permita o gerenciamento de uma lista de tarefas.
Esta API é utilizada na disciplina Desenvolvimento para Servidores-II.

## Desenvolvedores

- [@Luan Costa](https://github.com/luuwn)
- [@Lucas Maia](https://github.com/Homertex)

##  Documentação da API


| Recursos   |
| :---------------------------------- |
|GET - Para obter todas as tarefas ou detalhes de uma tarefa.
POST - Para criar uma nova tarefa.
DELETE - Para excluir uma tarefa.
PUT - Para atualizar todo os detalhes da tarefa.
PATCH - Para atualizar o status da tarefa, assim como os demais campos.


**Campos:**

| Task   |
| :---------------------------------- |
id (Long)
title (String)
description (String)
status (Enum [TODO, IN_PROGRESS, DONE])
dueDate (LocalDate)
priority (Enum [LOW, MEDIUM, HIGH])
