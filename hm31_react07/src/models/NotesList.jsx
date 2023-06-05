import Note from "./Note";
import {useSelector} from "react-redux";

const NotesList = (props) => {
    const notes = useSelector((state) => state.notes);

    return (
        <div
            style={{
                padding: "8px",
                margin: "8px",
                display: "flex",
                width: "100%",
                flexWrap: "wrap",
                justifyContent: "center",
            }}
        >
            {notes &&
                notes.map((note, noteIndex) => (
                    <Note
                        key={`note-${noteIndex}-${note.title}`}
                        title={note.title}
                        description={note.description}
                    />

                ))}
        </div>
    );
};

export default NotesList;