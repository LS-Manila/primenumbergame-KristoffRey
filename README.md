# My version of the Prime Number Game!
This is a simple game application that has 3 difficulties and the player has to determine whether the randomly generated number is composite or prime.
The code used to generate the numbers is found below after the explaination of the difficulties.

#Easy
All natural numbers until 999 will be in the database

#Medium
Omits even numbers like 8, 98, 578

#Hard
Omits even numbers and numbers which are multiples of 5 like 5, 15, 20, 48

```
    private ArrayList loadList(int level){
        ArrayList<Integer> values = new ArrayList<>();
        switch (level){
            case 0:     //for easy
                for(int i=4;i<=LIMIT;i++){
                    values.add(i);
                }
                break;
            case 1:     //for medium
                for(int i=4;i<=LIMIT;i++){
                    if(i%2==0) {
                        //Does not add factors of 2 to the list
                    }
                    else {
                        values.add(i);
                    }
                }
                break;
            case 2:     //for hard
                for(int i=4;i<=LIMIT;i++){
                    if(i%2==0||i%5==0) {
                        //Does not add factors of 2 AND 5 to the list
                    }
                    else {
                        values.add(i);
                    }
                }
                break;
            default:
                Toast.makeText(this, "Error Identifying the difficulty!", Toast.LENGTH_SHORT).show();
                break;
        }
        return values;
    }
```

##Problem
To design a simple game that will question the user if the number is composite of prime and will keep track of a score afterwards.

##Solution
The algorithm for determining if a number is composite of prime is found below:

```
    public boolean checkPrime(Integer toCheck){
        for(Integer i=2;i<=toCheck/2;i++){
            if(toCheck%i==0){
                return false;
            }
        }
        return true;
    }

```

##Screenshots
![alt tag](https://github.com/KristoffRey/MyPrimeNumberGame/blob/master/Screenshot_2015-10-26-09-38-29.png)
![alt tag](https://github.com/KristoffRey/MyPrimeNumberGame/blob/master/Screenshot_2015-10-26-09-50-39.png)
![alt tag](https://github.com/KristoffRey/MyPrimeNumberGame/blob/master/Screenshot_2015-10-26-09-39-47.png)
