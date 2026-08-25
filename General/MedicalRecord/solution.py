import requests

def getAverageTemperatureForUser(userId):
    pageNum = 1
    totalTemp = 0.0
    count = 0
    
    while True:
        # An example record:
        # ------------------
        #
        # { 
        #  id: 11, 
        #  timestamp: 1563846626267, 
        #  diagnosis 
        #  {
        #    id: 2, 
        #    name: "Common Cold", 
        #    severity: 1
        #  }, 
        #  vitals: {
        #            bloodPressureDiastole: 126, 
        #            bloodPressureSystole: 75, 
        #            pulse: 99, 
        #            breathingRate: 22, 
        #            bodyTemperature: 101.9}, 
        #            userId: 3, 
        #            userName: "John Doe", 
        #            userDob: "23-12-1987",
        #            ...
        #          },
        apiEndpoint = f"https://jsonmock.hackerrank.com/api/medical_records?userId={userId}&page={pageNum}"
        response = requests.get(apiEndpoint)
        
        if response.status_code != 200: 
            break
        
        payload = response.json()
        records = payload.get('data', [])
        
        for r in records:
            vData = r.get('vitals', {})
            tempVal = vData.get('bodyTemperature')
            
            if tempVal is not None:
                totalTemp += float(tempVal)
                count += 1
        
        # pull total pages using snake_case field
        pages = payload.get('total_pages', 1)
        
        if pageNum >= pages:
            break
        
        pageNum += 1
        
    # string "0" if no records exist
    if count == 0:
        return "0"
        
    average = totalTemp / count
    # 1 decimal place format (e.g., "36.5")
    return "{:.1f}".format(average)
