# Makefile for Refactored Rex v2
# Type "make" to compile all Java classes.
# Type "make test1" to run a test with sample_exam.tex and seed 1.

PACKAGE = edu/udel/cisc675/rexv2
SRCFILES = RexApp.java ExamParser.java ExamModel.java Problem.java Answer.java \
           Shuffler.java ExamFormatter.java

SRC = $(addprefix src/$(PACKAGE)/,$(SRCFILES))
MAINBIN = bin/$(PACKAGE)/RexApp.class

all: $(MAINBIN)

$(MAINBIN): $(SRC)
	javac -d bin $(SRC)

test1: $(MAINBIN)
	java -cp bin edu.udel.cisc675.rexv2.RexApp examples/exam1.tex 1
	
test2: $(MAINBIN)
	java -cp bin edu.udel.cisc675.rexv2.RexApp examples/exam2.tex 2

test3: $(MAINBIN)
	java -cp bin edu.udel.cisc675.rexv2.RexApp examples/exam3.tex 3

clean:
	rm -rf bin/* *~ *.tmp

.PHONY: clean all test1 test2 test3
