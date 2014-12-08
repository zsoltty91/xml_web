xquery version "3.0";
module namespace inf = 'http://inf.unideb.hu/xml';

(: Az adott tanévben jelenlévő osztályok listája :)
declare function inf:osztalyok($tanev as xs:string) as node()* {
  for $i in doc('rendszer')//rendszer/osztalyok/osztaly
  where $i/tanev = $tanev
  return $i
};

declare function inf:aktivOsztalyok() as node()* {
  let $aktualisTanev := inf:tanevekId-descending()[1]
  let $osztalyok := inf:osztalyok($aktualisTanev)
  return $osztalyok  
};

(: Az adott évben az iskolába járó diákok listája, név szerint növekvő sorrendben :)
declare function inf:diakok($tanev as xs:string) as node()* {
  for $i in doc('rendszer')//rendszer/osztalyok/osztaly
  where $i/tanev = $tanev
    for $j in $i/diakok 
      let $v := $j/data(diak)
      for $k in doc('rendszer')//rendszer/diakok/diak
      where $k[@id=$v]
      order by $k/nev ascending
  return $k
};

(: A tanévek csökkenő sorrendben. :)
declare function inf:tanevekId-descending() as xs:token* {
  for $i in doc('rendszer')//rendszer/tanevek/tanev
  order by $i/mettol descending
  let $tanevek := $i/data(@id)
  return $tanevek
};

(: Jelenleg is az iskolába járó diákok listája, az utolsó tanév alapján :)
declare function inf:aktivDiakok() as node()* {
  let $aktualisTanev := inf:tanevekId-descending()[1]
  let $diakok := inf:diakok($aktualisTanev)
  return $diakok  
};

(: Egy szekvencia tartalmaz-e egy csomópontot :)
declare function inf:is-node-in-sequence ( $node as node()? ,$seq as node()* ) as xs:boolean {
   some $nodeInSeq in $seq satisfies $nodeInSeq is $node
};

declare function inf:is-value-in-sequence ( $value as xs:string ,$seq as xs:string* ) as xs:boolean {
   some $nodeInSeq in $seq satisfies $nodeInSeq = $value
};

(: Az iskola volt diákjai, avagy az utolsó tanévet leszamítva az összes diák :)
declare function inf:inaktivDiakok() as node()* {
  let $aktualisTanev := inf:tanevekId-descending()[1]
  let $diakok := inf:diakok($aktualisTanev)
  for $i in doc('rendszer')//rendszer/diakok/diak  
  where not(inf:is-node-in-sequence($i, $diakok))
  return $i 
};

(: Osztályfőnökök egy adott évben :)
declare function inf:osztalyfonokok($tanev as xs:string) as node()* {
  let $ofok-listaja := doc('rendszer')//osztalyok/osztaly/osztalyfonok[../tanev=$tanev]
  for $i in doc('rendszer')//rendszer/tanarok/tanar
  where inf:is-value-in-sequence(data($i/@id), data($ofok-listaja))
  return $i
};

(: Eddig még sosem voltak osztályfőnökök :)
declare function inf:sose-osztalyfonokok($tanev as xs:string) as node()* {
  let $ofok-listaja := doc('rendszer')//osztalyok/osztaly/osztalyfonok
  for $i in doc('rendszer')//rendszer/tanarok/tanar
  where not(inf:is-value-in-sequence(data($i/@id), data($ofok-listaja)))
  return $i
};

(: Az iskola 3 eddigi legjobb diakja átlagot tekintve :)
declare function inf:top-3-diak() as node()* {
  let $diakok := db:open('rendszer')//rendszer/diakok/diak  
  let $diak-atlag := for $i in $diakok
                      let $atlag := $i/jegyei/jegy/erdemjegy  
                      return <diak>{$i/nev}<atlag>{avg(data($atlag))}</atlag></diak>
  
  let $diak-atlag-desc := for $i in $diak-atlag order by $i/atlag descending return $i
  
  for $i in subsequence($diak-atlag-desc, 1, 3)   
  return $i
};

declare function inf:top-3-diak($tanev as xs:string) as node()* {
  let $diakok := inf:diakok($tanev)
  let $diak-atlag := for $i in $diakok
                      let $atlag := $i/jegyei/jegy/erdemjegy  
                      return <diak>{$i/nev}<atlag>{avg(data($atlag))}</atlag></diak>
  
  let $diak-atlag-desc := for $i in $diak-atlag order by $i/atlag descending return $i
  
  for $i in subsequence($diak-atlag-desc, 1, 3)   
  return $i  
};

declare function inf:max-id-szunet() as xs:double {
  let $id := db:open('rendszer')/rendszer/tanevek/tanev/szunetek/szunet/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-diak() as xs:double {
  let $id := db:open('rendszer')/rendszer/diakok/diak/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-tanar() as xs:double {
  let $id := db:open('rendszer')/rendszer/tanarok/tanar/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-jegy() as xs:double {
  let $id := db:open('rendszer')/rendszer/diakok/diak/jegyei/jegy/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-fogadoora() as xs:double {
  let $id := db:open('rendszer')/rendszer/tanarok/tanar/fogadoorak/fogadoora/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-ora() as xs:double {
  let $id := db:open('rendszer')/rendszer/osztalyok/osztaly/orarend/ora/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};

declare function inf:max-id-tantargy() as xs:double {
  let $id := db:open('rendszer')/rendszer/tantargyak/tantargy/@id
  let $result := if (fn:empty(fn:max($id))) then 0 else fn:max($id)
  return  $result
};
