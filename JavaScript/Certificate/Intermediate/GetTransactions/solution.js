'use strict';

const fs = require('fs');
const https = require('https');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
      inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
      return inputString[currentLine++];
}

async function getNumTransactions(username) {
    // Users endpoint:         https://jsonmock.hackerrank.com/api/article_users?username=<username>
    // Transactions endpoint:  https://jsonmock.hackerrank.com/api/transactions?&userId=<userId>
    const fetchRemoteJson = (targetUrl) => {
        return new Promise((resolvePromise, rejectPromise) => {
            https.get(targetUrl, (httpResponse) => {
                let chunkBuffer = '';
                
                httpResponse.on('data', (chunkByte) => {
                    chunkBuffer += chunkByte;
                });
                
                httpResponse.on('end', () => {
                    try {
                        resolvePromise(JSON.parse(chunkBuffer));
                    } catch (jsonException) {
                        rejectPromise(jsonException);
                    }
                });     
            }).on('error', (networkError) => {
                rejectPromise(networkError);    
            });
        });
    };
    
    const userUrl = 'https://jsonmock.hackerrank.com/api/article_users?username=<username>';
    const transactionUrl = 'https://jsonmock.hackerrank.com/api/transactions?&userId=<userId>';
    
    try {
        const userRequestUrl = userUrl.replace('<username>', username);
        const retrieveProfile = await fetchRemoteJson(userRequestUrl);
        
        if (!retrieveProfile || !retrieveProfile.data || retrieveProfile === 0) { return "Username Not Found"; }
        
        const userInteger = retrieveProfile.data[0].id;
        const transactionRequestUrl = transactionUrl.replace('<userId>', userInteger);
        const retrievedTransaction = await fetchRemoteJson(transactionRequestUrl);
        
        return retrievedTransaction.total;
    } catch (runtimeException) {
        return "Username Not Found";
    }
}
  
