(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Quito (Distrito
  Metropolitano de Quito, Ecuador) -- the TWENTY-THIRD municipality-
  level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town for the first
  twenty-two) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL gob.ec (Ecuador's own official
  government portal, which also indexes municipal/metropolitan
  ordinances alongside national law) URL -- never fabricated,
  matching the same reliable source used for this country's
  statute.facts one tick earlier. An ordinance not in this table has
  NO spec-basis, full stop; extend `catalog`, do not invent an
  id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"quito"
   [{:ordinance/id "quito.codigo-municipal-ordenanza-072-2024"
     :ordinance/title "Código Municipal para el Distrito Metropolitano de Quito (Ordenanza Metropolitana N.º 072-2024)"
     :ordinance/municipality "quito"
     :ordinance/country "ECU"
     :ordinance/kind :ordinance
     :ordinance/number "Ordenanza Metropolitana N.º 072-2024"
     :ordinance/url "https://www.gob.ec/regulaciones/codigo-municipal-distrito-metropolitano-quito-ordenanza-metropolitana-no-072-2024"
     :ordinance/url-provenance :official-gob-ec
     :ordinance/enacted-date "2024-05-30"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "quito.ordenanza-090-2025-tasas-residuos"
     :ordinance/title "Ordenanza Metropolitana N.º 090-2025 (Tasas por Servicios Complementarios en la Gestión Integral de Residuos)"
     :ordinance/municipality "quito"
     :ordinance/country "ECU"
     :ordinance/kind :ordinance
     :ordinance/number "Ordenanza Metropolitana N.º 090-2025"
     :ordinance/url "https://www.gob.ec/regulaciones/ordenanza-metropolitana-no-090-2025"
     :ordinance/url-provenance :official-gob-ec
     :ordinance/enacted-date "2025-04-09"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:waste-management :environment}}]})

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
      :note (str "cloud-itonami-municipality-ecu-quito Wave 0 (ADR-2607141700): "
                 (count (get catalog "quito")) " Quito entries seeded "
                 "with an official gob.ec citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
