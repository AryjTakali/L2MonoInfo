open Printf
(* ========================================== *)
(* == LU2IN019 - C. Ramdani       3805942  == *)
(* == TP 1                                 == *)
(* ========================================== *)


(* == Question 1 == *)
let f (x: int) (y:int) : int =
        x + y + 2

let _ = assert ((f 3 2) = 7)
let _ = assert ((f 0 0) = 2)
let _ = assert ((f (-1) (-1)) = 0)


(* ============ Exercice 4 ===================*)

(* pour cette exercice j'ai choisi d'inverser l'ordre des duet/quartet *)
(* afin d'avoir une meilleure visibilité *)
(* 2 == 1 0 *)

(* == Question 1 == *)
type bit = bool
type duet = bool * bool
type quartet = bool * bool * bool * bool


(* == Question 2 == *)
let xor (x: bit) (y: bit) : bit =
  if (x = y) then false
  else true

let _ = assert ((xor true true) = false)
let _ = assert ((xor false true) = true)
let _ = assert ((xor false false) = false)


(* == Question 3 == *)

let half_adder (a: bit) (b: bit) : duet =
  if (a = b && a = true) then (true, false)
  else (false, xor a b)

let _ = assert ((half_adder false false) = (false, false))
let _ = assert ((half_adder true false) = (false, true))
let _ = assert ((half_adder true true) = (true, false))


(* == Question 4 == *)

let adder (a: bit) (b: bit) (c :bit): duet =
  let (r1, s1) = half_adder a b in
  let (r2, s2) = half_adder s1 c in
  (r1 || r2, s2)


(* == Question 5 == *)
let _ = assert ((adder false false false) = ( false, false))
let _ = assert ((adder false false true) = ( false, true))
let _ = assert ((adder true true true) = ( true, true))
let _ = assert ((adder true false true) = ( true, false))


(* == Question 6 == *)

let duet_adder (x1, y1 : duet) (x2, y2: duet) (r :bit): (duet * bit) =
  let (r1, s1) = adder y1 y2 r in
  let (r2, s2) = adder x1 x2 r1 in
  (s2, s1), r2

let _ =assert (duet_adder (true,true) (true,true) (true)  = ((true,true),true))
let _ =assert (duet_adder (false ,false) (false,false) (false)  = ((false,false),false))
let _ =assert (duet_adder (false ,true) (false,false) (false)  = ((false,true),false))
let _ =assert (duet_adder (false,true) (false,true) (true)  = ((true,true),false))
let _ =assert (duet_adder (false,true) (true,true) (false)  = ((false,false),true))


(* == Question 7 == *)

let quartet_adder (t1, x1, y1, z1 : quartet) (t2, x2, y2, z2: quartet) (r :bit): (quartet * bit) =
  let (r1, s1) = adder z1 z2 r in
  let (r2, s2) = adder y1 y2 r1 in
  let (r3, s3) = adder x1 x2 r2 in
  let (r4, s4) = adder t1 t2 r3 in
  (s4, s3, s2, s1), r4

let _ =assert (quartet_adder (true, true, true, true) (true, true, true, true) (true)  = ((true, true, true, true), true))
let _ =assert (quartet_adder (true, true, true, true) (true, true, true, true) (false)  = ((true, true, true, false), true))
let _ =assert (quartet_adder (false, false, false, false) (false, false, false, false) (true)  = ((false, false, false, true), false))
let _ =assert (quartet_adder (to_quartet 0) (to_quartet 1) (false)  = ((to_quartet 1), false))
let _ =assert (quartet_adder (to_quartet 5) (to_quartet 5) (false)  = ((to_quartet 10), false))
let _ =assert (quartet_adder (to_quartet 11) (to_quartet 3) (false)  = ((to_quartet 14), false))
let _ =assert (quartet_adder (to_quartet 0) (to_quartet 0) (false)  = ((to_quartet 0), false))

(* == Question 8 == *)

let check (nb : int) (div : int) : (int * int) =
  (nb/div, nb - (nb/div) * div)

let to_quartet (nb : int) : (quartet) =
  let (t, nb1) =  check nb 8 in
  let (x, nb2) = check nb1 4 in
  let (y, nb3) = check nb2 2 in
  let (z, nb4) = check nb3 1 in
  (t = 1, x = 1, y = 1, z = 1)
  
  let _ =assert (to_quartet (0) = (false, false, false, false))
  let _ =assert (to_quartet (1) = (false, false, false, true))
  let _ =assert (to_quartet (2) = (false, false, true, false))
  let _ =assert (to_quartet (3) = (false, false, true, true))
  let _ =assert (to_quartet (4) = (false, true, false, false))
  let _ =assert (to_quartet (15) = (true, true, true, true))