# test_task0
Случайно отправленное мне на e-mail тестовое задание.

При обращении к программе по определенному сетевому порту она должна 
выдавать набор случайных символов ascii (5 символов от 'a' до 'z' и от 
'A' до 'Z'), текущее время и полученные по сети символы в hex.
Для проверки работоспособности клиентскую программу нет надобности 
реализовывать. Проверять можно с помощью стандартной утилиты telnet.

Пример:
 o 127.0.0.1 8746
 >telnet 127.0.0.1 8746
 >Hello

Ответ: tYhhO 10/10/14 16:37:15 48 65 6C 6C 6F
