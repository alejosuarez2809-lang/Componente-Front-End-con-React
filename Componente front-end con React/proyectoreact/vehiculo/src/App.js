// Importación de estilos principales de la aplicación
import './App.css';

// Importación de iconos de PrimeReact
import 'primeicons/primeicons.css';

// Importación del tema visual de PrimeReact
import "primereact/resources/themes/lara-light-blue/theme.css";

// Importación de React y Component para crear componentes de clase
import React, { Component } from 'react';

// Importación del servicio que maneja las operaciones CRUD de vehículos
import { VehiculoService } from './services/VehiculoService.js';

// Componentes de PrimeReact utilizados en la interfaz
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Panel } from 'primereact/panel';
import { Menubar } from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import { FloatLabel } from 'primereact/floatlabel';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Toast } from 'primereact/toast';

// Componente principal de la aplicación
export default class App extends Component {

    // Constructor principal
    constructor() {
        super();

        // Estado inicial de la aplicación
        this.state = {

            // Controla la visibilidad del diálogo
            visible: false,

            // Lista de vehículos
            vehiculos: [],

            // Objeto vehículo utilizado en el formulario
            vehiculo: {
                id: null,
                placa: null,
                tipo: null,
                marca: null,
                color: null,
                propietario: null
            },

            // Vehículo seleccionado en la tabla
            SelectedVehiculo: {}
        };

        // Opciones del menú superior
        this.items = [

            // Botón para crear nuevo vehículo
            {
                label: "Nuevo",
                icon: "pi pi-plus",
                command: () => { this.ShowSaveDialog() }
            },

            // Botón para editar vehículo seleccionado
            {
                label: "Editar",
                icon: "pi pi-pencil",
                command: () => { this.showEditDialog() }
            },

            // Botón para eliminar vehículo seleccionado
            {
                label: "Eliminar",
                icon: "pi pi-trash",
                command: () => { this.delete() }
            }
        ];

        // Instancia del servicio de vehículos
        this.VehiculoService = new VehiculoService();

        // Enlace del método save
        this.save = this.save.bind(this);

        // Pie del diálogo con botón guardar
        this.footer = (
            <div>
                <Button
                    label="Guardar"
                    icon="pi pi-check"
                    onClick={this.save}
                />
            </div>
        );

        // Referencia para las notificaciones Toast
        this.Toast = React.createRef();
    }

    // Método que se ejecuta al cargar el componente
    componentDidMount() {

        // Obtiene todos los vehículos desde el backend
        this.VehiculoService.getAll()

            .then(data => {

                // Guarda los datos en el estado
                this.setState({ vehiculos: data });
            })

            .catch(error => {

                // Muestra error en consola
                console.error("Error al obtener vehículos:", error);
            });
    }

    // Método para guardar un vehículo
    save() {

        // Envía el vehículo al backend
        this.VehiculoService.save(this.state.vehiculo)

            .then(data => {

                // Reinicia el formulario y oculta el diálogo
                this.setState({

                    visible: false,

                    vehiculo: {
                        id: null,
                        placa: null,
                        tipo: null,
                        marca: null,
                        color: null,
                        propietario: null
                    }
                });

                // Mensaje de éxito
                this.Toast.current.show({
                    severity: "success",
                    summary: "Éxito",
                    detail: "Vehículo guardado correctamente"
                });

                // Actualiza la tabla
                this.VehiculoService.getAll()
                    .then(data => this.setState({ vehiculos: data }))
            });
    }

    // Método para eliminar vehículo
    delete() {

        // Confirmación antes de eliminar
        if (window.confirm("¿Desea eliminar el vehículo seleccionado?")) {

            // Llama al servicio para eliminar
            this.VehiculoService.delete(this.state.SelectedVehiculo.id)

                .then(data => {

                    // Mensaje de eliminación
                    this.Toast.current.show({
                        severity: "warn",
                        summary: "Eliminado",
                        detail: "Vehículo eliminado correctamente"
                    });

                    // Recarga los datos
                    this.VehiculoService.getAll()
                        .then(data => this.setState({ vehiculos: data }))
                });
        }
    }

    // Muestra el diálogo para registrar vehículo
    ShowSaveDialog() {

        this.setState({

            visible: true,

            // Limpia los campos
            vehiculo: {
                placa: "",
                tipo: "",
                marca: "",
                color: "",
                propietario: ""
            }
        });
    }

    // Muestra el diálogo con los datos del vehículo seleccionado
    showEditDialog() {

        this.setState({

            visible: true,

            // Carga los datos en el formulario
            vehiculo: {

                id: this.state.SelectedVehiculo.id,
                placa: this.state.SelectedVehiculo.placa,
                tipo: this.state.SelectedVehiculo.tipo,
                marca: this.state.SelectedVehiculo.marca,
                color: this.state.SelectedVehiculo.color,
                propietario: this.state.SelectedVehiculo.propietario
            }
        });
    }

    // Método render: dibuja la interfaz
    render() {

        return (

            // Contenedor principal
            <div
                style={{
                    background: "linear-gradient(135deg, #0F172A, #1E3A8A)",
                    minHeight: "100vh",
                    padding: "30px"
                }}
            >

                {/* Panel principal */}
                <Panel
                    header="Gestión de Vehículos"
                    style={{
                        width: "95%",
                        margin: "0 auto",
                        borderRadius: "20px",
                        overflow: "hidden",
                        boxShadow: "0px 4px 20px rgba(0,0,0,0.3)"
                    }}
                >

                    {/* Barra de menú */}
                    <Menubar
                        model={this.items}
                        className="menubar-blanco"
                        style={{
                            background: "#1E3A8A",
                            border: "none",
                            borderRadius: "10px",
                            marginBottom: "20px"
                        }}
                    />

                    {/* Tabla de vehículos */}
                    <DataTable

                        value={this.state.vehiculos}

                        paginator
                        rows={10}

                        stripedRows
                        showGridlines
                        responsiveLayout="scroll"

                        selectionMode="single"

                        selection={this.state.SelectedVehiculo}

                        onSelectionChange={(e) =>
                            this.setState({ SelectedVehiculo: e.value })
                        }

                        tableStyle={{
                            minWidth: '50rem'
                        }}
                    >

                        {/* Columnas de la tabla */}
                        <Column field="id" header="ID"></Column>

                        <Column field="placa" header="Placa"></Column>

                        <Column field="color" header="Color"></Column>

                        <Column field="marca" header="Marca"></Column>

                        <Column field="tipo" header="Tipo"></Column>

                        <Column field="propietario" header="Propietario"></Column>

                    </DataTable>

                    {/* Ventana emergente del formulario */}
                    <Dialog

                        header="Registro de Vehículo"

                        visible={this.state.visible}

                        style={{ width: '450px' }}

                        footer={this.footer}

                        modal={true}

                        onHide={() => this.setState({ visible: false })}
                    >

                        {/* Campo placa */}
                        <FloatLabel>

                            <InputText

                                style={{ width: "100%" }}

                                value={this.state.vehiculo.placa}

                                id='placa'

                                onChange={(e) => {

                                    let val = e.target.value

                                    this.setState(prevState => {

                                        let vehiculo = Object.assign({}, prevState.vehiculo);

                                        vehiculo.placa = val

                                        return { vehiculo };
                                    })
                                }}
                            />

                            <label htmlFor="placa">Placa</label>

                        </FloatLabel>

                        <br />

                        {/* Campo tipo */}
                        <FloatLabel>

                            <InputText

                                style={{ width: "100%" }}

                                value={this.state.vehiculo.tipo}

                                id='tipo'

                                onChange={(e) => {

                                    let val = e.target.value

                                    this.setState(prevState => {

                                        let vehiculo = Object.assign({}, prevState.vehiculo);

                                        vehiculo.tipo = val

                                        return { vehiculo };
                                    })
                                }}
                            />

                            <label htmlFor="tipo">Tipo</label>

                        </FloatLabel>

                        <br />

                        {/* Campo marca */}
                        <FloatLabel>

                            <InputText

                                style={{ width: "100%" }}

                                value={this.state.vehiculo.marca}

                                id='marca'

                                onChange={(e) => {

                                    let val = e.target.value

                                    this.setState(prevState => {

                                        let vehiculo = Object.assign({}, prevState.vehiculo);

                                        vehiculo.marca = val

                                        return { vehiculo };
                                    })
                                }}
                            />

                            <label htmlFor="marca">Marca</label>

                        </FloatLabel>

                        <br />

                        {/* Campo color */}
                        <FloatLabel>

                            <InputText

                                style={{ width: "100%" }}

                                value={this.state.vehiculo.color}

                                id='color'

                                onChange={(e) => {

                                    let val = e.target.value

                                    this.setState(prevState => {

                                        let vehiculo = Object.assign({}, prevState.vehiculo);

                                        vehiculo.color = val

                                        return { vehiculo };
                                    })
                                }}
                            />

                            <label htmlFor="color">Color</label>

                        </FloatLabel>

                        <br />

                        {/* Campo propietario */}
                        <FloatLabel>

                            <InputText

                                style={{ width: "100%" }}

                                value={this.state.vehiculo.propietario}

                                id='propietario'

                                onChange={(e) => {

                                    let val = e.target.value

                                    this.setState(prevState => {

                                        let vehiculo = Object.assign({}, prevState.vehiculo);

                                        vehiculo.propietario = val

                                        return { vehiculo };
                                    })
                                }}
                            />

                            <label htmlFor="propietario">Propietario</label>

                        </FloatLabel>

                    </Dialog>

                    {/* Componente de notificaciones */}
                    <Toast ref={this.Toast} />

                </Panel>

            </div>
        );
    }
}
