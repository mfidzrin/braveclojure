
;; if operator
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Odin's Elbow!")

;; if with do operator
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

;; use when if want to do multiple things if truthy and return nil when falsey
(when true
  (println "Success!")
  (println "Banyak kali!")
  (println (+ 1 2 3 4))
  "abra cadabra")

;; nil check
(nil? 1)
(nil? nil)

;; truthy check
(if "bears eat beets"
  "bears beets Battlestar Galactica")

;; falsey check
(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

;; equality operator
(= 1 1)

(= nil nil)

(= 1 2)

(= 1 1 2)

(= 1 1 1 1)

;; or & and operator
;; or return the first truthy value else the last one
(or false
    nil
    :large_I_mean_venti
    :why_cant_I_just_say_large)

(or false
    nil
    false
    nil)

(or (= 0 1) (= "yes" "no"))

;; and return the first falsey value else the last one
(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

;; Naming values with def
(def failed-protagonist-names
  ["Larry Potter" "Dorean the Exploer" "The Incredible Bulk"])

failed-protagonist-names

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOOOOMED!")))

(error-message :mild)

;; Data Stuctures
;; Numbers
93  ;; integer
1.2 ;; float
1/5;; ratio

;; Strings
"Lord Voldemort"
"\"He who mush not be named\""
"\"Great cow of Moscow!\" - Hermes Conrad"

(def name "Chewbacca")
(def chewbacca (str "\"Uggllglglglglglll\" - " name))
(println chewbacca)


;; Maps
{}
{:first-name "Charlie"
 :last-name "McFishwich"}

;; this maps contains a function for a value
{"string-key" +}

;; nested maps
{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}

;; create a map using a function - hash-map
(def simple-map (hash-map :a 1 :b 2))

(get simple-map :a)

;; keyword can be used as a function to look up value inside the map
(:a simple-map)
(:c simple-map "There is no number 3")

;; map can be used as a function with the key as its argument to get the value
(simple-map :a)

;; Keywords
:a
:rumplestiltsken
:34
:_?
(def onetwothree {:a 1 :b 2 :c 3})

(:a onetwothree) ;; using keyword as a function/operator
(get onetwothree :a) ;; using get function with map and keyword as the arguments
(:d onetwothree 4) ;; set default value for unmatch key

;; Vectors
[3 2 1]

(get [3 2 1] 0) ;; get 0th element of a vector
(nth [3 2 1] 1) ;; nth function to get nth element of a vector

(vector "creepy" "full" "moon")

(conj [1 2 3] 4) ;; conj is a function to add additional elements to the end of the vector

;; Lists
;; lists are similar to vector but linear collections of values
;; nth is slower than using get because Clojure has to traverse all n elements to get the nth value
'(1 2 3 4)

(get '(1 2 3 4) 0) ;; cannot retrieve list elements with get

(nth '(1 2 3 4) 0) ;; to retrieve list elemenets, use nth

;; we can create a list using list operator/function
(list 1 "two" 3 :4 {5 6}) ;; list values can have any type

(conj '(1 2 3 4) 5) ;; using conj on a list will add the element to the beginning of a list

;; Good rule of thumb when to use list
;; when we want to easily add items to the beginning of a sequence or
;; when we're writing a macro
