
		     Rex: The Exam Randomizer

Rex is used to randomly shuffle the problems and answers of a
multiple choice exam.  The given exam is in LaTeX format and
consists of the following sections, in order:

 1. possible text not including "\begin{problem}" or "\end{problem}"
 2. a sequence of problems
 3. possible text not including "\begin{problem}" or "\end{problem}"

Each problem has the following form:

 1. \begin{problem}
 2. possible text not including "\begin{enumerate}"
 3. \begin{enumerate}
 4. a sequence of answers
 5. \end{enumerate}
 6. possible text
 7. \end{problem}

Each answer has the following form:
 1. \item
 2. text not including "\item" or "\end{enumerate}"

See exam1.tex for a typical example.

Rex is a command line tool which takes 2 arguments: the name of the
file containing the exam in the format described above, and a long
integer which is the seed to Java's random number generator.  It reads
the file, randomly permutes the problems and answers to each problem,
and then writes the output to stdout in the same format as the
original file.

Design: Rex was developed using a modular design.  The modules are:

  1. Input
  2. FindProblems
  3. FindAnswers
  4. RandomizeProblems
  5. RandomizeAnswers
  6. Output
  7. Rex (main class)

Each module is a Java class.  See the comments in the source files to
see what each module does.

Potential changes/additions: here are some ways the app may have to
change in the future:

  0. Better/more robust error reporting.

  1. Ignore text in LaTeX comments (comments start with % and extend
     to end of line)

  2. An exam may be divided into sections.  Randomize within each
     section but do not move a problem from one section to another.

  3. Provide a way for the user to indicate which answer is correct.
     Make Rex keep track of the correct answers as it permutes.
     Produce an answer key at the end, in either plain text or
     Scantron format.

  4. Allow the user to produce n random exams instead of just one.

  5. Tell Rex to select a random subset of problems, rather than
     all problems.  The subset must meet some user-specified
     constraints.  For example, the user might associate points to
     each problem and the constraint may be to select a set of
     problems for which the total number of points is as specified.

  6. Allow some "free form" (short essay) problems in addition to
     multiple choice.
 
To build from command line: type "make".  Type "make test1" to run a
test.  See the Makefile for further details.

This project is also configured as an Eclipse project.


Critique of Design V1:

While the Rex application adopts a modular structure with seven clearly separated classes 
the design does not adhere to the deeper principles of 
information hiding and design for change, as advocated by David Parnas. 
Each module in Rex is defined by a processing step (e.g., FindProblems, FindAnswers, etc.), 
rather than by encapsulating a design decision that might change. 
This leads to a pipeline-style architecture where the output of one module directly gets fed to the next.

Such decomposition makes the system face issues when doing any change change. 
For instance, any modification in the LaTeX structure (e.g., new formatting conventions, support for comments, or nested environments) 
may require coordinated changes across multiple modules, violating the principle that a single module should absorb the impact of change. 

Design V2

Modules 
1.ExamApplication - The main application module that orchestrates the overall process.
2.LaTeXParser - Module for parsing LaTeX files into an abstract representation.
3.Exam - Module representing the complete structure of an exam.
4.Questions - Module representing a single question with its answers.
5.Answers - Module representing a single multiple-choice answer.
6.ExamRandomizer - Module for randomizing exam elements.
7.LaTeXWriter: Module for writing an exam back to LaTeX format.

USES Relation 

1.ExamApplication USES LaTeXParser, Exam, ExamRandomizer, LaTeXWriter
2.LaTeXParser USES Exam, Question, Answer
3.Exam USES Question, ExamRandomizer
4.Question USES Answer, ExamRandomizer
5.ExamRandomizer USES Exam, Question, Answer
6.LaTeXWriter USES Exam, Question, Answer


Anticipation Of Change 

Change 1: Supporting Different Input/Output Formats (e.g., Markdown or HTML)
Design v1 Impact: The original design would require extensive changes across multiple modules. Format-specific code is scattered throughout the codebase:

1.FindProblems and FindAnswers hardcode LaTeX patterns
2.Output has LaTeX-specific knowledge embedded in its logic
3.Almost every module would need modification to support new formats

Design v2 Impact:
In the new design, only the parser and writer modules would need to be modified:

1.Create new parser classes implementing a common interface: MarkdownParser, HTMLParser2
2.Create new writer classes: MarkdownWriter, HTMLWriter
3.Modify ExamApplication to select the appropriate parser and writer based on file extension
4.The Exam, Question, and Answer classes would remain unchanged

Change 2: Adding Support for Different Question Types (e.g., Fill-in-the-blank, Essay)
Design v1 Impact:The original design assumes all questions are multiple-choice with the same LaTeX structure:

1.FindAnswers hardcodes the expectation of \begin{enumerate} and \item
2.The randomization logic assumes all answers can be permuted.
3.Would require changes to at least 3-4 modules, with high risk of introducing bugs

Design v2 Impact:The new design could be extended with minimal changes:

1.Create a QuestionType interface or abstract class
2.Extend the Question class hierarchy with MultipleChoiceQuestion, EssayQuestion, etc.
3.Modify LaTeXParser to identify question types during parsing
4.Update LaTeXWriter to handle formatting for different question types
5.ExamRandomizer would need to check question type before attempting randomization
6.Core modules remain intact

Change 3: Adding a GUI or Web Interface

Design v1 Impact:The original design is tightly coupled to the processing flow and operates directly on text files:

1.No separation between business logic and I/O operations
2.Would require significant refactoring to separate concerns
3.Character-based processing is difficult to integrate with a GUI

Design v2 Impact:The new design cleanly separates model, processing, and I/O:

1.Create a new UI module that interacts with existing modules
2.No changes needed to Exam, Question, or Answer classes
3.LaTeXParser and LaTeXWriter already handle file operations separately from data model
4.UI could directly manipulate the exam model before generating output

