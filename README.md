<h1>Progetto GranPrix Gruppo 6</h1>
<p>Creato da Drosu Razvan, Martinelli Federico e Nucciarelli Giorgio</p>
<p>Ecco i nostri tag @SecretSatyr @fexmart05 @MovingN</p>
<h2>Descrizione</h2>
<p>Questo progetto è stato commissionato dalle professoresse Ciuchetti e Fioroni.<br>Il progetto coinsiste nella creazione di un programma prettamente eseguito in  un terminale,<br> dove l'utente può gestire una gara tra delle automobili, che vengono scelte dall'utente,<br> insieme alla lunghezza della gara ed al numero di giri e pit stop, ogni macchina può essere manomessa dall'utente, ed avremo un giudice di gara che si occuperà di segnalare le posizioni/inizio/fine ed anomalie avvenute nella gara. </p>
<h2>Struttura</h2>
<p>Troverete queste classi all'interno del progetto:</p>
<ol>
	<li>GrandPrix6 : Corrisponde alla classe main del progetto. </li>
	<li>Giocatore : Classe che estende Thread che serve per svolgere tutte le azioni richieste dall'utente.</li>
	<li>GiudiceDiGara : Classe che estende Thread che si occupa della comunicazione dell'inizio/fine gara e della comunicazione delle posizioni.</li>
  <li>Circuito : Classe contenente gli attributi della lunghezza e dei giri.</li>
  <li>Pilota : Classe contenente gli attributi del pilota, come nome, cognome, nazionalità e numero di macchina, quest'ultimo servirà al giocatore per decidere quale macchina truccare.</li>
  <li>Auto : Classe contenente gli attributi dell'auto, come la velocità, la marca ed il modello, questa classe serve a mantenere le velocità di ogni singola auto, che verrà poi associata ad un pilota.</li>
</ol>
