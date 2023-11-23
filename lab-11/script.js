async function generateChart() {
    // Write your code here. You can write your own function(s) if you want.

    const response = await fetch("https://restcountries.com/v3.1/all");
    const data = await response.json();
    const populationData = data.slice(0, document.getElementById("numberOfCountries").value).map((country) => {
        return {
            name: country.name.common,
            population: country.population,
        };
    });
    const ctx = document.getElementById("barChart");
    try {
        chart.destroy();
    } catch (error) {}
    chart = new Chart(ctx, {
        type: "bar",
        data: {
            labels: populationData.map((country) => country.name),
            datasets: [
                {
                    label: "Total Population",
                    data: populationData.map((country) => country.population),
                    borderWidth: 1,
                    backgroundColor: "#DAF2F2",
                    borderColor: "#4BC0BF",
                },
            ],
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: "Population",
                    },
                },
            },
        },
    });
}
