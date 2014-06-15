;;;; Magician's extensions to the Integer class.

(ns magician.integer
  (:require [clojure.math.numeric-tower]))

(defn factorial
  "Gets the factorial of an integer.

  This is equivalent to the product of all integers from 1 to the integer
  (inclusive). When the integer is 0, it is equivalent to 1."
  [n]
  (cond
    (< n 0) false
    (= n 0) 1
    (> n 0) (reduce * (range 1 (inc n)))))

(defn prime?
  "Returns true if an integer is prime.

  An integer is prime if it is not divisible by any integer between 1 and the
  integer itself, exclusive. 0 and 1 are not prime numbers, though 2 is prime.
  Negative numbers are never considered prime in this implementation."
  [n]
  (if (<= n 1)
    false
    (not-any? (fn [i] (= (mod n i) 0))
      (range 2 (clojure.math.numeric-tower/sqrt n)))))
