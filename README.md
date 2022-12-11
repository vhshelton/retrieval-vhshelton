# retrieval-vhshelton
my first search engine!

## OOA comments

- Which class is the information expert (is responsible for)
   removeStopWord
   Checks if an input contains any stopwords and returns the stripped input

- The "Terminate Progam" use case is a bit thin.

- Consider including a StopList class.  It is easier to delete an existing class than it is to create a missed class, so i'll advocate including class Stoplist.

## OOD comments

-- "HashMap<Document> index;"  play with this type to get some zen for it.

-- for args in query
        Look for document with the query in it
        return doc;
   check this against the expected result for a two-word query

-- "- index - HashSet index (words)"  this is to vague ... which words?  go demand that your analysis be more precise ;-)

-- "... = createIndex(contents);" == "makeIndex" ??




## Examples

The JavaDoc for the game OneRowNim can be fount at

  <a href="https://cs-312.github.io/nim"> JavaDoc served from GitHub Pages </a>
  
  <a href="http://www.cs.loyola.edu/~binkley/312/src/javadoc-examples/Nim.docs"> JavaDoc served from Linux </a>


The directory `testing` includes a simple test case.  Note that the script 
`test0` assumes that your code is in its parent directory.

