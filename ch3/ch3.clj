
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

;; Sets
;; Sets are collections of unique values
;; Have 2 kinds of sets: hash sets and sorted sets
;; Hash set:
(def one-set #{"kurt vonegut" 20 :icicle})

;; can use hash-set operator to create a set:
(hash-set "kurt vonegut" 20 :icicle)

(conj #{:a :b} :b) ;; when added existing value, nothing happens

;; creating sets from vectors
(set [3 3 3 4 4])

(contains? one-set :a) ;; would return false

(contains? one-set :icicle) ;; would return true

(contains? #{nil} nil)

;; using keyword to get value from a set
(:icicle one-set)
;; using get to get value from a set
(get one-set 20)


;; Functions
;; Calling functions
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])
(last [1 2 3 4])
(nth [1 2 3 4] 1)

;; same syntax across Clojure operations
;; in the form of:
;; (operator operand1 operand2 ... operandnth)
;;
(or + -)

((or + -) 1 2 3) ;; from previous exercise, or return the first truthy value

((and (= 1 1) +) 1 2 3) ;; from previous exercise, and return the first falsey value or last value

(1 2 3 4) ;; not a valid function call since numbers aren't functions
("first" 1 2 3 4) ;; not a valid function call since strings aren't functions

;; higher order functions
(inc 1.1)

(map inc [0 1 2 3]) ;; note that map doesn't return a vector, even though we supploed a vector as an argument
;; We'll learn why in Chapter 4

;; here is how Clojure would evalueate a function call
;; see these operations as steps
(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2))) ;; evalutated "(inc 199)"
(+ 200 (/ 100 5)) ;; evaluated (- 7 2)
(+ 200 20) ;; evaluated (/ 100 5)
220 ;; final evaluation

;; Function Calls, Macro Calls, and Special Forms
;; Macro calls and Special forms evaluate their operands differently from normal functions calls
;; and they also can't be passed as arguments to functions

;; Defining Functions
;; functions definitions are composed of five main parts:
;; - defn
;; - function name
;; - a docstring describing the function (optional)
;; - parameters listed in brackets
;; - function body
;; examples:

(defn too-enthusiastic
  "Return a cheer that might be a bit too enthisiastic"
  [name]
  (str
   "OH. MY. GOD! "
   name
   " YOU ARE MOST DEFINITELY LIKE THE BEST"
   "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")

;; what is docstring?
;; The docstring is a useful way to describe and document your code.
;; You can view the docstring for a function in the REPL via (doc <fn-name>)
;; For example:
(doc map) ;; return a nill but a description of this function map will be display in the REPL

;; what is parameters and arity?
;; Clojure functions can be defined with zero or more parameters.
;; The value we pass to functions are called arguments (which can be any type)
;; The number of parameters is the function's arity.
;; Here are some function definitions with different arities:
(defn no-params
  []
  "I take no parameters!") ;; 0-arity function

(defn one-param
  [x]
  (str "I take one parameter: " x)) ;; 1-arity function

(defn two-params
  [x y]
  (str "Two parameters! That's nothing! Pah! I will smossh them "
       "together to spite you!"
       x
       y)) ;; 2-arity function
(two-params "Nothing" "Nothing")

;; Functions also support arity overloading
;; this means that we can define a function with multiple body
;; and it will run depending on the arity.

(defn do-things
  [& _args]
  (str "Do nothing")) ;; made up function to make below function linting error disappear
(defn multi-arity
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
   (do-things first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (do-things first-arg second-arg))
  ([first-arg]
   (do-things first-arg)))

(defn multi-arity-2
  ([x y]
   (str "Two parameters! That's nothing! Pah! I will smossh them "
        "together to spite you!"
        x
        y))
  ([x]
   (str "I take one parameter: " x))
  ([]
   "I take no parameters!"))

(multi-arity-2 "Nothing")

;; Arity overloading is one way to provide default values for arguments
(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West" "slap")

(x-chop "Jasf")

;; Clojure also allows us to define variable-arity functions
;; it's called rest parameter which indicated by ampersand (&)
;; as in "put the rest of these arguments in a list with the following name"
;; arguments treated as a list

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Hulk")

;; We can mix rest parameters with normal parameters but the rest parameter has to come last
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: " (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

;; Destructuring
