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
# Activate corresponding ruleflow group 'guess_animal_fc'
my_engine.activate('guess_animal_fc')

# Forward Chaining - To find out all new conclusions/knowledge
my_engine.get_kb('guess_animal_facts').dump_specific_facts()


print('\n====================== Start of Backward Chaining ======================')
my_engine.reset()

# Activate corresponding ruleflow group 'guess_animal_bc'
my_engine.activate('guess_animal_bc')

# Backward Chaining - To find out the animal name
test_animals = ['Bird', 'Cheetah', 'Tiger', 'Zebra']

for animal in test_animals:
    try:
        goal, _ = my_engine.prove_1_goal('guess_animal_bc.'+animal+'(Unknown, $flag)')
        print('Is the unknown animal:', animal, '?')
        print('Yes')
    except knowledge_engine.CanNotProve:
        print('Is the unknown animal:', animal, '?')
        print('No')
