(ns defworkshop.state-to-recursion
  (:require [workshoplib.tdd :refer […]]))

;; More often than not, state can be avoided by using recursion. Let's see how it works

(defn reverse-coll
  "Reverse the collection `coll`.

   You can use `loop/recur` construct to loop over the sequence.
   `cons` prepends items to the list, try that out."
  [coll]
  ( loop [ l coll acc '() ] (if (empty? l) acc (recur (rest l) (cons (first l) acc)))))

(defn recursive-sum
  "We've already implemented sum using reduce, now let's move to implementing it via recursion!"
  [[head & tail]]
   (if head
     (+ head (recursive-sum tail))
     0
 ))

(defn recursive-sum-tc
  "with a tail-recursive version of sum, we can avoid stack overflows."
  ([coll]
     (recursive-sum-tc coll 0))
  ([[head & tail] acc]
	(if (empty? tail) 
         (+ acc head)
         (recursive-sum-tc tail (+ acc head))   
        )
)
)

(defn max-from-list
  "Get the maximum from list using recursion"
  [[head & tail]]
  (if (empty? tail)
    head
    (let [x (max-from-list tail)]
    (if (> head x) head x ))))

(defn ^:not-implemented my-reduce
  "generalizing the recursive sum example, write your own implementation of reduce! (for empty coll, just return nil.)"
  ([f [head & tail]]
     (my-reduce f head tail))
  ([f acc-init coll]
     (…)))

(defn ^:not-implemented max-from-list-tc
  "Get the maximum from list using tail recursion (avoid stack overflow)"
  ([coll]
     (max-from-list-tc coll 0))
  ([[head & tail] max]
     (loop [[head & tail] max acc 0]
	(if (nil? head) acc  
        (recur tail (if (> head acc) head acc ) )      
  )
)
)
)

(defn ^:not-implemented loop-recur-sum
  "This implementation is somewhat easier to understand for people coming from imperative style."
  [numbers]
  (…))

(defn ^:not-implemented map-from-keys-and-vals
  "Something that we've already implemented previously in terms of `zipmap`, but are going to implement again
   in terms of recursion. Usually you use `loop/recur` construct whenever you have a one or multiple accumulators
   or several collections you iterate over."
  [keys vals]
  (…))

(defn ^:not-implemented parentheses-balanced?
  "Check wether the given string has balanced parantheses or no.

   You can use `cond` statement to avoid deeply nested ints.
   It's a recursive problem, so you'll have to build up stack to solve it.

   `inc` increments a number, `dec` decrements a number."
  ([str] (parentheses-balanced? str 0))
  ([[current & tail] count]
     (…)))
