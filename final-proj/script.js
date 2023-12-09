const setResult = (state) => {
    document.getElementById("not-found").style.display = "none";
    document.getElementById("loading").style.display = "none";

    document.getElementById("result").style.display = "none";

    if (state === "not-found") {
        document.getElementById("not-found").style.display = "flex";
    } else if (state === "loading") {
        document.getElementById("loading").style.display = "flex";
    } else if (state === "found") {
        document.getElementById("result").style.display = "flex";
    }
};

const handleSearch = async (e) => {
    let word = document.getElementById("input").value;
    setResult("loading");
    if (word == "" || word === null) {
        setResult(0);
        return;
    }
    try {
        const response = await fetch(`https://api.dictionaryapi.dev/api/v2/entries/en/${word}`);
        const data = await response.json();
        if (!response.ok) {
            setResult("not-found");
            document.getElementById("not-found-text").textContent = `sorry, we could not find the word "${word}"`;
            document.getElementById("input").value = "";
        } else {
            document.getElementById("word").replaceChildren();
            document.getElementById("content-container").replaceChildren();

            setResult("found");
            document.getElementById("input").value = "";

            document.getElementById("word").textContent = data[0].word;
            const contentContainer = document.getElementById("content-container");
            const meanings = data[0].meanings;
            for (let m of meanings) {
                let meaning = document.createElement("div");
                meaning.classList.add("meaning-container");
                let part = document.createElement("p");
                part.textContent = `[${m.partOfSpeech}]`;
                part.classList.add("part");
                meaning.appendChild(part);
                for (let d of m.definitions) {
                    let definition = document.createElement("p");
                    definition.textContent = d.definition;
                    definition.classList.add("definition");
                    meaning.appendChild(definition);
                }
                contentContainer.appendChild(meaning);
            }
        }
    } catch (error) {
        console.log(error);
    }
};

window.onload = () => {
    const inputBox = document.getElementById("input");
    inputBox.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            document.getElementById("submit-button").click();
        }
    });
};
