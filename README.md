### To solve cors route in java 
we use ```@CrossOrigin("http://localhost:5173")```

### In java using ```list.stream().filter(---/---).toList()``` is risky
### That's why us 
### ```list.stream().filter(---/---).collect(Collectors.toList())```
or
### ```new ArrayList<>(list.stream().filter(---/---).toList())```
these two generate a modifiable list instead of unmodifiable

### Older getPatientByQuery 
```declarative
@Override
    public List<PatientDto> getPatientByQuery(String firstName, String lastName, String city){
        List<Patient> patients = patientRepository.findAll();
        if( !firstName.isEmpty())
            patients = patientRepository.findByFirstName(firstName);
        else if( !lastName.isEmpty())
            patients = patientRepository.findByLastName(lastName);
        else if( !city.isEmpty())
            patients = patientRepository.findByCity(city);
        return patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
    }

    public List<PatientDto> getPatientByQuery(String firstName, String lastName, String city, String email, String contact){
        List<Patient> patients = patientRepository.findAll();

        if( !firstName.isEmpty())
            patients = patients.stream().filter( p -> p.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
        if( !lastName.isEmpty())
            patients = patients.stream().filter( p -> p.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
        if( !city.isEmpty())
            patients = patients.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());

        return patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
    }
```

## Free Open AI Testing API KEYS
## https://github.com/dan1471/FREE-openai-api-keys