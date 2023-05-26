import './App.css'
import InfoCardMUI from "./InfoCardMUI.jsx";

import BooksTable from "./BooksTable.jsx";

const cards = [
    {
        image : "https://www.rpnation.com/data/avatars/l/46/46072.jpg?1488651191",
        question : "Cui ne adresam?",
        separatorClass : "red",
        description : "Programele de formare sunt dedicate tuturor celor care doresc sa invete si sa aprofundeze programare.",
    },
    {
        image : "https://www.pngall.com/wp-content/uploads/2016/04/Potato-High-Quality-PNG-180x180.png",
        question : "Cine sunt mentorii?",
        separatorClass : "orange",
        description : "Trainerii Devmind au o vechime de peste 4 ani atat in mediul academic cat si in industria IT."
    },
    {
        image : "https://i.pinimg.com/originals/8a/8f/45/8a8f45fe1b8a3face03dabf755738bbc.jpg",
        question : "Cum se desfasoara?",
        separatorClass : "blue",
        description : "Procesul de predare este 100% orientat pe practica, astfel incat se pune accentul atat pe sedimentarea cunostintelor invatate cat si pe dobandirea unor abilitati fundamentale."
    }

];


function App() {


  return (
<div>
      <div id="infoCardsContainer">
          {cards.map( e => (
                  <InfoCardMUI
                      image={e.image}
                      question={e.question}
                      separatorClass={e.separatorClass}
                      description={e.description}
                      key={e.question}/>

              )
          )
          }
      </div>
    <p> </p>
    <BooksTable/>
</div>
  )
}

export default App
