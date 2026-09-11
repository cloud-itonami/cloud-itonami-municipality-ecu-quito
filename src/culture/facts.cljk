(ns culture.facts
  "Regional-culture catalog for Quito -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto
  this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"quito"
   [{:culture/id "quito.dish.fanesca"
     :culture/name "Fanesca"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :dish
     :culture/summary "Soup traditionally prepared only on Good Friday and eaten across Ecuador; by the 19th century Quito was already celebrating Holy Week with fanesca."
     :culture/url "https://en.wikipedia.org/wiki/Fanesca"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.dish.fritada"
     :culture/name "Fritada"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :dish
     :culture/summary "Traditional braised-pork dish of the Ecuadorian highlands, with origins dating to the colonial era."
     :culture/url "https://en.wikipedia.org/wiki/Fritada"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.dish.hornado"
     :culture/name "Hornado"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :dish
     :culture/summary "Whole roast pig of Ecuadorian cuisine, often served in highland markets."
     :culture/url "https://en.wikipedia.org/wiki/Hornado"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.dish.locro"
     :culture/name "Locro"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :dish
     :culture/summary "Hearty stew eaten across the South American Andes; in Ecuador a variant known as yahuarlocro is popular."
     :culture/url "https://en.wikipedia.org/wiki/Locro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.beverage.canelazo"
     :culture/name "Canelazo"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :beverage
     :culture/summary "Hot alcoholic beverage consumed in the Andean highlands, popular in Ecuador during holidays and Quito festivities."
     :culture/url "https://en.wikipedia.org/wiki/Canelazo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.festival.fiestas-de-quito"
     :culture/name "Fiestas de Quito"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :festival
     :culture/summary "Week-long celebrations from the end of November to 6 December commemorating the founding of Quito."
     :culture/url "https://en.wikipedia.org/wiki/Fiestas_de_Quito"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.heritage.historic-center"
     :culture/name "Historic Center of Quito"
     :culture/name-local "Centro Histórico de Quito"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :heritage
     :culture/summary "Historic center of Quito; in 1978 Quito and Kraków were the first World Cultural Heritage Sites declared by UNESCO."
     :culture/url "https://en.wikipedia.org/wiki/Historic_Center_of_Quito"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.heritage.el-panecillo"
     :culture/name "El Panecillo"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :heritage
     :culture/summary "200-metre hill of volcanic origin in Quito, topped by a 45-metre aluminium winged Madonna monument inaugurated in 1975."
     :culture/url "https://en.wikipedia.org/wiki/El_Panecillo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "quito.heritage.basilica-del-voto-nacional"
     :culture/name "Basílica del Voto Nacional"
     :culture/municipality "quito"
     :culture/country "ECU"
     :culture/kind :heritage
     :culture/summary "Neo-Gothic Roman Catholic church in Quito's historic center, built between 1892 and 1988 and reaching 83 metres in height."
     :culture/url "https://en.wikipedia.org/wiki/Bas%C3%ADlica_del_Voto_Nacional"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-ecu-quito culture catalog "
                 "(ADR-2607171400): " (count (get catalog "quito"))
                 " Quito entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
