# Who Killed Hello Kitty case in "HelloKitty" folder

## Introduction
  Here is a rule-based logical deduction system for ***WhoKillHellokitty problem***.

  ***hellokitty_facts.kfb*** is the knowledge base containing initial facts

  ***hellokitty_fc.krb*** is the ruleflow group containing the rules (inference knowledge) needed for ***forward chaining***

  ***hellokitty_bc.krb*** is the ruleflow group containing the rules (inference knowledge) needed for ***backward chaining***

  ***compiled_krb*** is the folder containing python script which is the python version of the rules. Pyke compile the rules in ***hellokitty_fc.krb*** and ***hellokitty_bc.krb*** into python ***class*** so that it can be called by the rule engine.

  ***hellokitty.py*** is the python/test script to compile the rule engine and execute the fc and bc.

  ***Important note***: In pyke, rules for fc and bc are in different format, so you need to write down the rules respectively

## To query/test the system:
  Install the 'Pyke' package. Link:https://sourceforge.net/projects/pyke/files/pyke/1.1.1/

  ***Important note***: Download ***pyke3-1.1.1.zip*** for Python3 and ***pyke1.1.1.zip*** for Python2

  Open and run the ***hellokitty.py*** in python shell.
