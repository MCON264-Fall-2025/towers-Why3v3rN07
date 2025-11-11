#  MCON 264 — Recursion Assignment: Towers of Hanoi × 3


##  Overview

In this lab, you implemented three recursive versions of the Towers of Hanoi problem and (optionally) one iterative version.  
Each part reinforces a key concept of recursion — base case, recursive case, and growth pattern — and illustrates how recursion can be refactored or replaced by iteration.

---

## Part 1 — Classic Towers of Hanoi (`TowersOfHanoi.java`)

### 1. Base Case
_Describe the base condition that stops recursion (for example, what happens when `n == 0`?)._

> When n==0, return; exit the current recursion and continue in the previous iteration.

### 2. Recursive Case
_Explain the sequence of recursive calls and what each represents._

> Move n-1 discs from the starting peg to the auxiliary peg, then move the nth disc to the end peg, 
> then move the rest of the discs to the ending peg too.

### 3. Sample Trace (for n = 3)

| Move # | From |  To  |
|:------:|:----:|:----:|
|   1    |  A   |  C   |
|   2    |  A   |  B   |
|   3    |  C   |  B   |
|   4    |  A   |  C   |
|   5    |  B   |  A   |
|   6    |  B   |  C   |
|   7    |  A   |  C   |

_Total moves = 2ⁿ − 1 = 7 (for n = 3)_

---

## Part 2 — Counting Moves (`TowersExercise21.java`)



### 1. Approach
_How did you modify the standard recursion to count rather than print moves?_

>  Created a counter variable, and incremented it in place of printing the moves.

### 2. Verification of Formula
_Complete the table and verify that count = 2ⁿ − 1._

| n | Expected (2ⁿ - 1) | Program Output | Matches? (Y/N) |
|:-:|:-----------------:|:--------------:|:--------------:|
| 1 |         1         |       1        |       Y        |
| 2 |         3         |       3        |       Y        |
| 3 |         7         |       7        |       Y        |
| 4 |        15         |       15       |       Y        |
| 5 |        31         |       31       |       Y        |

### 3. Reflection
_What changes when you replace printed moves with a counter? What are the pros and cons?_

> You can see the total moves easily, without counting the steps, but you don't get to see the individual moves; 
> you wouldn't be able to tell if you were getting the right answer through the wrong means. 

---

## Part 3 — Hanoi Variation (`TowersVariations.java`)

### 1. New Rule
_Every move must pass through the middle peg. How does this alter the recursion?_

> It adds an extra level, as each time you move the base you now need to move the rest of the stack _twice_.

### 2. Base Case
_Describe the base condition that stops recursion (for example, what happens when `n == 0`?)._

> When n==0, return; exit the current recursion and continue in the previous iteration.

### 3. Recursive Case
_Explain the sequence of recursive calls and what each represents._

> Move n-1 discs from the starting peg to the end peg, then move the nth disc to the middle peg,
> then move the n-1 tower from the end peg back to the start, then move the nth disc to the end peg, 
> then move the n-1 tower from the start peg to the end peg.



### 4. Observed Move Counts

| n |Expected ≈ 3ⁿ − 1 | Program Output | Matches? (Y/N) |
|:-:|:----------------:|:--------------:|:--------------:|
| 1 |        2         |       2        |       Y        |
| 2 |        8         |       8        |       Y        |
| 3 |        26        |       26       |       Y        |
| 4 |        80        |       80       |       Y        |

### 5. Analysis
_Why does this variation grow faster than the standard version? How do additional move constraints affect complexity?_

> The base is higher, 'cause every move now spawns an extra recursion, as you've got to move the tower twice, since you 
> can only move discs one peg at a time. 

---

## Comparative Analysis

### 1. Growth Patterns

|       Version        | Approx. Formula |           Growth Type            |
|:--------------------:|:---------------:|:--------------------------------:|
|       Standard       |     2ⁿ − 1      |           Exponential            |
|      Variation       |     3ⁿ − 1      |       Exponential (faster)       |
| Iterative (Optional) |     2ⁿ − 1      | Same as recursive but loop based |

### 2. Move Count Comparison

| n  | V1+V2 |  V3   |
|:--:|:-----:|:-----:|
| 1  |   1   |   2   |
| 2  |   3   |   8   |
| 3  |   7   |  26   |
| 4  |  15   |  80   |
| 5  |  31   |  242  |
| 6  |  63   |  728  |
| 7  |  127  | 2186  |
| 8  |  255  | 6560  |
| 9  |  511  | 19682 |
| 10 | 1023  | 59048 |


### 3. Stack Depth and Memory
1. Discuss what happens if you increase n significantly — why does a stack overflow occur? 
2. Estimate the maximum recursion depth before StackOverflowError and discuss how stack size (–Xss flag) affects this._

> 1. If n is too high the recursion depth will exceed your allotted stack size and you'll get Stack Overflow.
> 2. Generally between 5 and 30 thousand.  Your -Xss setting sets the max stack size for your thread, but depending on 
> your system memory you might not even hit that limit. 
 

---

## Discussion &amp; Reflection

1. What three questions can you use to verify a recursive solution works?
>(From the book:)
>   1) Is there a nonrecursive way out of the method, and does the method work correctly for this base case?
>   2) Does each recursive call to the method involve a smaller case of the original problem, leading inescapably to the base case?
>   3) Assuming the recursive calls work correctly, does the method work in the general case?

2. How do the base case and recursive case cooperate to guarantee termination?
> The recursion makes sure the program keeps going smaller and smaller until it hits the base case, at which point it goes back up and ends.

3. What is the trade-off between elegance and efficiency in recursion?
> Recursion can be elegant, taking less code and less space, but it's often not the most efficient solution, as it consumes a lot of memory and time.

4. Which version (printing, counting, or variation) demonstrates recursion most clearly? 
> In my opinion the printing version showed recursion the clearest 'cause you could see the movements of the pieces.

---

## References (APA or MLA format)

- Dale, N., Joyce, D., &amp; Weems, C. (2016). *Object-Oriented Data Structures Using Java* (Ch. 3 Recursion). Jones &amp; Bartlett.
- “Tower of Hanoi/Variant.” ProofWiki, https://proofwiki.org/wiki/Tower_of_Hanoi/Variant. . Accessed 11 Nov. 2025.
---

 **Submission Checklist**

- [x] `TowersOfHanoi.java` — implemented and tested
- [x] `TowersExercise21.java` — counts moves correctly
- [x] `TowersVariations.java` — middle-peg constraint implemented
- [x] All JUnit tests pass (green on GitHub Actions)
- [x] This `ANSWERS.md` file completed and committed to repo  
