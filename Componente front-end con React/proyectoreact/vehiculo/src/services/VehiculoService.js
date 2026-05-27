import axios from 'axios';

export class VehiculoService {
    baseUrl = "http://localhost:8080/vehiculos";

    getAll() {
        return axios.get(this.baseUrl).then(res => res.data);
    }

    
    save(vehiculo) {
        return axios.post(this.baseUrl, vehiculo, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.data);
    }

    
    delete(id) {
        return axios.delete(this.baseUrl + '/' + id).then(res => res.data);
    }
}