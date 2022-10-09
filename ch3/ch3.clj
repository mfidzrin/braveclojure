
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
;; Vectors
(defn my-first
  [[first-thing _  _]]
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn choose
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices."
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(choose ["one" "two" "three" "four"])

;; Maps
(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

;; break keywords out of a map
(defn announce-treasure-location
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

;; Function Body
;; Function body can contain forms of any kind
;; Clojure automatically returns the last form evaluated
(defn illustrative-function
  []
  (+ 1 304)
  20
  "joe")

(illustrative-function)

;; body function using if expression
(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)

(number-comment 7)

;; Anonymous Function
;; (fn [param-list]
;;  function body)
(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Aloha "])

(def my-special-multiplier (fn [x] (* x 3)))

(my-special-multiplier 12)

(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])

;; Distinction between function call and anonymous function
;; function call
(* 8 3)

;; Anonymous function
#(* % 3)

;; use the anonymous function
(#(* % 3) 8)

;; the percent sign %, indicates the argument passed to the function
;; for multiple arguments, %1 %2 %3

(#(str %1 " and " %2) "cornbread" "butter beans")

;; we can also pass a rest parameters with %&
(#(identity %&) 1 "blarg" :yip)

;; Pulling It All Together
;; The Shire's Next Top Model
;; For our hobbit model, we'll eschew such hobbit characteristics as joviality and
;; mischievousness and focus only on the hobbit's tiny body. Here's the hobbit model:

(def asym-hobbit-body-parts [{:name "head"           :size 3}
                             {:name "left-eye"       :size 1}
                             {:name "left-ear"       :size 1}
                             {:name "mouth"          :size 1}
                             {:name "nose"           :size 1}
                             {:name "neck"           :size 2}
                             {:name "left-shoulder"  :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest"          :size 10}
                             {:name "back"           :size 10}
                             {:name "left-forearm"   :size 3}
                             {:name "abdomen"        :size 6}
                             {:name "left-kidney"    :size 1}
                             {:name "left-hand"      :size 2}
                             {:name "left-knee"      :size 2}
                             {:name "left-thigh"     :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles"  :size 1}
                             {:name "left-foot"      :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-part
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-part asym-hobbit-body-parts)

;; Code break down
;; let

;; let binds names to values
(let [x 3] ;; x is a name with a binding value of 3
  x)

(def dalmation-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmations (take 2 dalmation-list)]
  dalmations)

;; let also introduce new scope

(def x 0)
x ;; => 0
(let [x 1] x) ;; => 1

;; reference existing bindings in let
(let [x (inc x)] x)
;; above example show x inside the (inc x) refers to the binding created by (def x 0)

;; usage of rest parameters & in let
(let [[pongo & dalmations] dalmation-list]
  [pongo dalmations])

;; loop
(defn test-it
  []
  (loop [iteration 0]
    (println (str "Iteration " iteration))
    (if (> iteration 3)
      (println "Goodbye!")
      (recur (inc iteration)))))

;; Regular Expressions
;; #"regular-expresstion"

(re-find #"^left-" "left-eye")

(re-find #"^left-" "cleft-chin")

(re-find #"^left-" "wongleblart")

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-eye" :size 1})

(matching-part {:name "head" :size 3})

;; Better Symmetrizer with reduce
(reduce + [1 2 3 4])

;; similar to
(+ (+ (+ 1 2) 3) 4)

;; The reduce function works according to the following steps:
;; 1. Apply the given function to the first elements of a sequece.
;; 2. Apply the given function to the result and the next element of the sequence.
;; 3. Repeat step 2 for every remaining element in the sequence.
;;
;; reduce also takes an optional initial value.
;; The initial value here is 15:
(reduce + 15 [1 2 3 4])

;; reduce also can be used to retur an even larger collection that the one we started with
(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce #(into %1 (set [%2 (matching-part %2)]))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-num (reduce + (map :size sym-parts))
        target (rand body-part-size-num)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)

;; Exercises

;; 1. Use the str, vector, list, hash-map, and hash-set functions.
(defn greeting
  [name]
  (str "Hello, " name))

(greeting "Fidzrin")

(vector 1 2 3)

(list 1 2 3)

(hash-map :latitude 10 :longiture 20)

(hash-set 1 2 3)

;; 2. Write a function that takes anumber and adds 100 to it.

(defn add-100
  "Add 100 to the argument provided"
  [number]
  (+ number 100))

(add-100 5)

;; 3. Write a function, dec-maker, that works exactly like the function inc-maker except with substration:
(defn dec-maker
  "Decrementor"
  [dec-by]
  #(- % dec-by))
(def dec9 (dec-maker 9))
(dec9 10)

;; 4. Write a function, mapset, that works like map except the return value is a set:
(defn mapset
  [func number]
  (set (map func number)))

(mapset inc [1 1 2 2])

;; 5. Create a function that's similar to symmetrize-body-parts except that it has to work with weird space aliens
;; with radial symmetry. Instead of two eyes, arms, legs and so on, they have five.
(defn- replace-part
  [part pre]
  {:name (clojure.string/replace (:name part) #"^left-" pre)
   :size (:size part)})

(defn matching-part-radial
  [part]
  (vector (replace-part part "right-")
          (replace-part part "top-")
          (replace-part part "bottom-")
          (replace-part part "middle-")))

(flatten [{:name "test" :size 1} {:name "test2" :size 2}])

(defn better-symmetrize-body-parts-2
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce #(into %1 (set (flatten [%2 (matching-part-radial %2)])))
          []
          asym-body-parts))

(better-symmetrize-body-parts-2 asym-hobbit-body-parts)
