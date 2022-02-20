from pyke import knowledge_engine
import shutil
import os

# Housekeeping
# Linux:
os.system('rm -rf compiled_krb')
#
# if os.path.exists('./compiled_krb'):
#     shutil.rmtree('./compiled_krb', ignore_errors=True, onerror=None)

# Build the rule-based system. Compile the rules
my_engine = knowledge_engine.engine(__file__)

print('\n====================== Start of Forward Chaining ======================')
my_engine.reset() # Should reset?

# Activate corresponding ruleflow group 'hellokitty_fc'
my_engine.activate('hellokitty_fc')

# Forward Chaining - To find out all new conclusions/knowledge
my_engine.get_kb('hellokitty_facts').dump_specific_facts()


print('\n====================== Start of Backward Chaining ======================')
my_engine.reset() # Should reset?

# Activate corresponding ruleflow group 'hellokitty_bc'
my_engine.activate('hellokitty_bc')

# Backward Chaining - To find out who killed Hello Kitty
goal, _ = my_engine.prove_1_goal('hellokitty_bc.Kill($creature, Hellokitty, True)')
print(goal['creature']+' killed Hello Kitty!')
