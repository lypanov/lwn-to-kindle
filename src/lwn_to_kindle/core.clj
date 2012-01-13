(ns lwn-to-kindle.core
  (:require [clojure.pprint :as pprint]
   :use net.cgrand.enlive-html))

; [:body :td (text-pred #(re-matches #"Alerts" %))] nil

(defn -main [& args]
  ; ./nov10.html
  (print (apply str (emit* (at (html-resource (java.io.File. 
                                                "./nov10.html"
                                                ; "./blah.html"
                                                             ))
              [:.TopNavigation] nil
              [:.Page :> :tr] unwrap
              [:.Page :> :td] unwrap
              [:.Page] unwrap
              [:body :> :table] unwrap
              ))))
  ; (pprint (select (html-resource (java.io.File. "./blah")) [:img]))
  ; (-> (html-resource "./nov10.html")
  ;   (select [:body]) pprint)
)
