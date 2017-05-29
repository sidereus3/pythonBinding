# # @In
# # @DataType("double")
# a
# # @In
# # @DataType("double")
# b
# # @Role(PARAMETER + OUTPUT)
# # @In
# # @DataType("string")
# pf

# @Initialize
def initialize():
    # @Out
    # @DataType("string")
    global init
    init = "initialization"

# @Execute
def execute():
    # @Out
    # @DataType("double")
    global summ
    # @Out
    # @DataType("double")
    global prod
    summ = a + b
    prod = a * b
    # @Out
    # @DataType("string")
    global res
    res = "the computation is done"
    target = open(pf, 'w')
    target.write(str(summ))
    target.write("\n")
    target.write(str(prod))
    target.write("\n")
    target.write(res)
    target.close()

# @Finalize
def finalize():
    # @Out
    # @DataType("string")
    global fin
    fin = "process done"
