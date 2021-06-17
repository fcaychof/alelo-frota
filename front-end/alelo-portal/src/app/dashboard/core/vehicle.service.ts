import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { NormaModal } from './../norma/model/norma.modal'
import { FormGroup } from '@angular/forms'

const API_URL = 'http://localhost:8087/api'

@Injectable({
    providedIn: 'root'
})
export class VehicleService {

    constructor(private http: HttpClient) { }

    listAll() {
        return this.http.get<[]>(API_URL + '/vehicle')
    }

    updateStatus(id) {
        return this.http.delete<>(API_URL + '/vehicle/' + id)
    }

    getById(id) {
        return this.http.get<>(API_URL + '/vehicle/' + id)
    }

    add(addForm: FormGroup) {
        return this.http.post<>(API_URL + '/vehicle',
            {
                //dataVigencia: addForm.get('dataVigencia').value,

            })
    }

    edit(addForm: FormGroup, id) {
        return this.http.put<>(API_URL + '/norma',
            {
                //id: id,

            })
    }
}


