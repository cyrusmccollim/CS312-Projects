# Tests

### Documents

- stop.txt
`the it and is for but`

- doc1.txt
`
For although a man is judged by his actions,
by what he has said and done, a man judges
himself by what he is willing to do, by what
he might have said, or might have done – a judgment
that is necessarily hampered, though only by the scope
and limits of his imagination, but by the ever-changing
measure of his doubt and self-esteem.
`
- doc2.txt
`
Their beliefs have become more fanciful,
their hypotheses less practical, their counsel less
germane. Unconfirmed suspicion tends, over time,
to become wilful, fallacious, and prey to the
vicissitudes of mood–it acquires all the qualities
of common superstition–and by the men of the Crown
Hotel, only whose nexus of allegiance is stitched,
after all, in the bright thread of time and
motion, have, like all men, no immunity to influence.
`

### Tests

Usage
`java Driver stop.txt doc1.txt doc2.txt`

Query: `and`
- Expected: `No results.`
- Rationale: Ensure stop word is ignored.

Query: `and bright`
- Expected: `doc2.txt`
- Rationale: Ensure the second document is found and the stop word is ignored.

Query: `only to`
- Expected: `doc1.txt doc2.txt`
- Rationale: Ensure the first and second documents are found.

Query: `only willing`
- Expected: `doc1.txt`
- Rationale: Ensure the first document is found.

Query: `but`
- Expected: `No results.`
- Rationale: Ensure stop word is ignored.

Query: `said`
- Expected: `doc1.txt`
- Rationale: Ensure the first document is found.

Query: `does not exist`
- Expected: `No results.`
- Rationale: Ensure no documents are found.

Query: `ever`
- Expected: `doc1.txt`
- Rationale: Ensure the first document is found containing a word that is present as a larger compound word in the document.
