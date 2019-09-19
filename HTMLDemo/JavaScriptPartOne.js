window.onload = function () {
    // select element with id "fizzBuzzButton"
    // apply an event listener to it to make it clickable
    // define anonymous function to be invoked when it is clicked
    // this anonymous function is a CALLBACK function - executes when
    // another function has finished executing
    document.getElementById("fizzBuzzButton").addEventListener("click", function () {
        let num1 = document.getElementById("num1").value;
        let word1 = document.getElementById("word1").value;
        let num2 = document.getElementById("num2").value;
        let word2 = document.getElementById("word2").value;
        // console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
        fizzBuzzOrSimilar(num1, word1, num2, word2);
    });

    document.getElementById("fizzBuzzButton2").addEventListener("click", function () {
        let numArray = document.getElementById("numArray").value;
        let wordArray = document.getElementById("wordArray").value;
        fizzBuzzOrSimilar2(numArray, wordArray);
    });
}

function fizzBuzzOrSimilar(num1, word1, num2, word2) {
    console.log(`num1 is ${num1}, replaced by ${word1}, and num2 is ${num2}, replaced by ${word2}`);
    for (var i = 1; i < 101; i++) {
        if ((i % (num1 * num2)) === 0) {
            console.log(word1 + word2);
        }
        else if ((i % num1) === 0) {
            console.log(word1)
        }
        else if ((i % num2) === 0) {
            console.log(word2)
        }
        else {
            console.log(i)
        }
    }
}

function fizzBuzzOrSimilar2(numArray, wordArray) {
    var numArraySplit = numArray.split(",");
    var wordArraySplit = wordArray.split(",");
    console.log(numArraySplit.length)
    if (numArraySplit.length != wordArraySplit.length) { 
        console.log("Different Lengths, try again")
    }
    else {

        n = numArraySplit.length
        for (var i = 1; i < 100; i++) {
            while (n > 0) {
                index = numArraySplit.length - n;
                var y = numArraySplit[index] * numArraySplit[index+1]
                if (y%i == 0) {
                    console.log(wordArraySplit[index] + wordArraySplit[index+1])
                }
                n = n -1
            }
            console.log(i)
        }
    }
        /*
        
        for (var i = 1; i < 101; i++) {
            for (var j = 0; j < numArraySplit.length; j++) {
                if ((numArraySplit[j]%i) == 0){
                    console.log(wordArraySplit[j])
                }
                else {
                    console.log(i)
                }
            }
        }
    }
          */
}