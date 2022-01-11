(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (if (true? knight-awake?) false true))

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (if (or (true? knight-awake?) (true? archer-awake?) (true? prisoner-awake?)) true false)
  )

(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (if (and (false? archer-awake?) (true? prisoner-awake?))
    true
    false))

(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (def sleeping-enemis? (and (false? knight-awake?) (false? archer-awake?)))
  (def just-knight-awake? (and (true? knight-awake?) (false? archer-awake?)))

  (if (and (true? dog-present?) (true? sleeping-enemis?)) 
    true
    (if (and sleeping-enemis? (true? prisoner-awake?)) 
      true
      (if (and just-knight-awake? (true? dog-present?))
        true
        false))))
