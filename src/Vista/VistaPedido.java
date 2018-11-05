
package Vista;

import Modelo.SwingUtils;
import Modelo.Mesero;
import Modelo.MeseroData;
import Modelo.Categoria;
import Modelo.CategoriaData;
import Modelo.Cliente;
import Modelo.ClienteData;
import Modelo.Mesa;
import Modelo.MesaData;
import Modelo.Pedido;
import Modelo.PedidoData;
import Modelo.Producto;
import Modelo.ProductoData;
import Modelo.Conexion;
import Modelo.Detalle;
import Modelo.DetalleData;
import Modelo.Reserva;
import Modelo.ReservaData;

import Modelo.TheModel;
import static Vista.Principal.Escritorio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VistaPedido extends javax.swing.JInternalFrame {
    private List<JButton> botonesProducto,botonesCategoria,botonesMesa;
    private DefaultTableModel modelo;
    private Connection connection = null;
    private Conexion conexion;
    //----------------------------Mesa
    
    
    private ProductoData productoData;
    private ArrayList<Producto> listaProductos;
    
    private CategoriaData categoriaData;
    private ArrayList<Categoria> listaCategorias;
    
    private MesaData mesaData;
    private ArrayList<Mesa> listaMesas;
    
    //Mesero
    private MeseroData meseroData;
    private ArrayList<Mesero> listaMeseros;
    //Pedido
    private PedidoData pedidoData;
    private ArrayList<Pedido> listaPedidos;
    //Detalle
    private DetalleData detalleData;
    private ArrayList<Detalle> listaDetalles;
    //Cliente
    private ClienteData clienteData;
    private ArrayList<Cliente> listaClientes;
    //Reserva
    private ReservaData reservaData;
    private ArrayList<Reserva> listaReservas;
    
    public VistaPedido() {
        initComponents();

        //----------------------------Mesa
        botonesMesa = new ArrayList<>();
        botonesCategoria = new ArrayList<>();
        botonesProducto = new ArrayList<>();
        //----------------------------FinMesa
        try {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            modelo=new DefaultTableModel();
            categoriaData = new CategoriaData(conexion);
            productoData = new ProductoData(conexion);
            meseroData = new MeseroData(conexion);
            mesaData = new MesaData(conexion);
            pedidoData = new PedidoData(conexion);
            detalleData = new DetalleData(conexion);
            reservaData = new ReservaData(conexion);
            cargaCapacidadMesas();
            botonesCategoria();
            cargarTablaMesero();
            SwingUtils.setEnableContainer(pnlProducto, false);
            SwingUtils.setEnableContainer(pnlDetalle, false);
            //hora
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            tbHora.setText(horaActual);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProducto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlBotonesCategoria = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlBotonesProducto = new javax.swing.JPanel();
        pnlDetalle = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnSacar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sCantidad = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        tbTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnlMesas = new javax.swing.JPanel();
        cbCapacidad = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tMesero = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbHora = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnVerMesa = new javax.swing.JButton();
        pnlReserva = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tReserva = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        cbPagado = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        tbStock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tbPrecio = new javax.swing.JTextField();
        tbNom = new javax.swing.JTextField();
        pnlCambio = new javax.swing.JPanel();
        btnCambiar1 = new javax.swing.JButton();
        btnActual = new javax.swing.JButton();
        btnNueva = new javax.swing.JButton();
        tbActual = new javax.swing.JTextField();
        tbNueva = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        pnlProducto.setBackground(new java.awt.Color(153, 153, 255));
        pnlProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista Producto"));

        pnlBotonesCategoria.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane2.setViewportView(pnlBotonesCategoria);

        pnlBotonesProducto.setLayout(new java.awt.GridLayout(0, 5));
        jScrollPane3.setViewportView(pnlBotonesProducto);

        javax.swing.GroupLayout pnlProductoLayout = new javax.swing.GroupLayout(pnlProducto);
        pnlProducto.setLayout(pnlProductoLayout);
        pnlProductoLayout.setHorizontalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
        pnlProductoLayout.setVerticalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductoLayout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlProductoLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );

        pnlDetalle.setBackground(new java.awt.Color(153, 153, 255));
        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Detalle"));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar_A_48.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar_B_48.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSacar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sacar_A_48.png"))); // NOI18N
        btnSacar.setBorder(null);
        btnSacar.setContentAreaFilled(false);
        btnSacar.setFocusPainted(false);
        btnSacar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sacar_B_48.png"))); // NOI18N
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("CANTIDAD");

        sCantidad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jScrollPane1.setViewportView(tDetalle);

        tbTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("TOTAL");

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(sCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Mesas"));

        pnlMesas.setLayout(new java.awt.GridLayout(0, 2, 1, 0));
        jScrollPane4.setViewportView(pnlMesas);

        cbCapacidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCapacidadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Capacidad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbCapacidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Mesero"));

        tMesero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tMesero);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Fecha y Hora"));

        dcFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("FECHA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("HORA");

        tbHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbHora.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(tbHora))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 153, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Pedido"));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Nuevo_A.png"))); // NOI18N
        btnNuevo.setPreferredSize(new java.awt.Dimension(105, 25));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnVerMesa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVerMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Ver_A.png"))); // NOI18N
        btnVerMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnVerMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlReserva.setBackground(new java.awt.Color(0, 153, 255));
        pnlReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Reserva"));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Cancelar_A.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tReservaMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tReserva);

        javax.swing.GroupLayout pnlReservaLayout = new javax.swing.GroupLayout(pnlReserva);
        pnlReserva.setLayout(pnlReservaLayout);
        pnlReservaLayout.setHorizontalGroup(
            pnlReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addContainerGap())
            .addGroup(pnlReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlReservaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );
        pnlReservaLayout.setVerticalGroup(
            pnlReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlReservaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlReservaLayout.createSequentialGroup()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel11.setBackground(new java.awt.Color(0, 153, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Menu"));

        cbPagado.setText("PAGADO");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar_A_80.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar_B_80.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar_A_80.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar_B_80.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPagado)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPagado)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Producto"));

        tbStock.setEnabled(false);

        jLabel9.setText("Stock");

        jLabel10.setText("Precio");

        tbPrecio.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(tbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(tbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbNom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pnlCambio.setBackground(new java.awt.Color(0, 153, 255));
        pnlCambio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cambiar"));

        btnCambiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Cambiar_A.png"))); // NOI18N
        btnCambiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiar1ActionPerformed(evt);
            }
        });

        btnActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Actual_B.png"))); // NOI18N
        btnActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualActionPerformed(evt);
            }
        });

        btnNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mesa/Nueva_B.png"))); // NOI18N
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        tbActual.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbActual.setEnabled(false);
        tbActual.setMaximumSize(new java.awt.Dimension(6, 20));

        tbNueva.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbNueva.setEnabled(false);
        tbNueva.setMaximumSize(new java.awt.Dimension(6, 20));

        javax.swing.GroupLayout pnlCambioLayout = new javax.swing.GroupLayout(pnlCambio);
        pnlCambio.setLayout(pnlCambioLayout);
        pnlCambioLayout.setHorizontalGroup(
            pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCambioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbActual, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActual, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCambioLayout.setVerticalGroup(
            pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCambioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActual, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCambiar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCambio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        

        try {
            if(btnProductoSeleccionado == 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione un Producto", "Error", JOptionPane.WARNING_MESSAGE);
            }else if(Integer.parseInt(sCantidad.getValue().toString())== 0)
            {
                JOptionPane.showMessageDialog(null, "Agregar una cantidad", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                Pedido pedido = pedidoData.buscarPedidoMesa(btnMesaSeleccionada);
                
                Producto producto = productoData.buscarProducto(btnProductoSeleccionado);

                if(producto != null){
                    
                    double precio = producto.getPrecio();

                    int cantidad = parseInt(sCantidad.getValue().toString());
                    double total = cantidad * precio;

                    Detalle detalle = new Detalle(producto,pedido,cantidad,total);
                    detalleData.guardarDetalle(detalle);
                    int descontar=producto.getCantidad()-cantidad;
                    producto.setCantidad(descontar);
                    productoData.actualizarProducto(producto);
                    cargarTablaDetalle(pedido.getIdPedido());

                }
            }

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        int DetalleSeleccionada = this.tDetalle.getSelectedRow();
        
        if(DetalleSeleccionada==-1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila");
        }
        else
        {
            int iddetalle =Integer.parseInt(tDetalle.getValueAt(DetalleSeleccionada, 4).toString());
            
            Detalle detalle = detalleData.buscarDetalle(iddetalle);
            detalle.setActivo(false);
            
            detalleData.actualizarDetalle(detalle);
            Producto producto = productoData.buscarProducto(detalle.getProducto().getIdProducto());
            producto.setCantidad(producto.getCantidad()+detalle.getCantidad());
            productoData.actualizarProducto(producto);
            
            Pedido pedido = pedidoData.buscarPedidoMesa(btnMesaSeleccionada);
            cargarTablaDetalle(pedido.getIdPedido());
        }

    }//GEN-LAST:event_btnSacarActionPerformed

    private void cbCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCapacidadActionPerformed
        int seleccionado = Integer.parseInt(cbCapacidad.getSelectedItem().toString());
        
        pnlMesas.removeAll();
        botonesMesas(seleccionado);
    }//GEN-LAST:event_cbCapacidadActionPerformed

    private void btnVerMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMesaActionPerformed

        Pedido pedido = pedidoData.buscarPedidoMesa(btnMesaSeleccionada);
        if(btnMesaSeleccionada==0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if(pedido == null )
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa Ocupada", "Error", JOptionPane.WARNING_MESSAGE);
            RecargarPedido();

        }
        else if(pedido.getMesa().getEstado() == 1 )
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa Ocupada", "Error", JOptionPane.WARNING_MESSAGE);
//            RecargarPedido();
        }
        else if(pedido.getMesa().getEstado() == 2 )
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa Ocupada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            dcFecha.setDate(pedido.getFecha());
            
            Mesa mesa =mesaData.buscarMesa(pedido.getMesa().getIdMesa());

            Mesero mesero = meseroData.buscarMesero(pedido.getMesero().getIdMesero());
            for (int i = 0; i < tMesero.getRowCount(); i++) {
                if (tMesero.getValueAt(i, 0).equals(mesero.getIdMesero())) {
                    tMesero.changeSelection(i, 0, false, false);
                    break;
                }
            }
            cargarTablaDetalle(pedido.getIdPedido());
            SwingUtils.setEnableContainer(pnlProducto, true);
            SwingUtils.setEnableContainer(pnlDetalle, true);
        }
    }//GEN-LAST:event_btnVerMesaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int ReservaSeleccionada = this.tReserva.getSelectedRow();
        if(ReservaSeleccionada == -1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Reserva");
        }
        else
        {
            int idReerva =Integer.parseInt(tReserva.getValueAt(ReservaSeleccionada, 0).toString());
            Reserva reserva = reservaData.buscarReserva(idReerva);
            reserva.setActivo(false);
            reservaData.actualizarReserva(reserva);
            RecargarPedido();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        int MeseroSeleccionada = this.tMesero.getSelectedRow();
        Mesa mmss = mesaData.buscarMesa(btnMesaSeleccionada);
        cargarTablaDetalle(0); 
        try {
            if(mmss == null)
            {
               
                JOptionPane.showMessageDialog(null, "Seleccione una Mesa");
            }
            else if(mmss.getEstado() == 0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Mesa Libre");
            }
            else if(MeseroSeleccionada == -1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione un Mesero", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else if(dcFecha.getDate() == null)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Fecha", "Error", JOptionPane.WARNING_MESSAGE);
            }
           
            else
            {
                
                
                //Buscamos al Mesero
                int m =Integer.parseInt(tMesero.getValueAt(MeseroSeleccionada, 0).toString());

                Mesero mesero = meseroData.buscarMesero(m);

                java.util.Date date=dcFecha.getDate();
                long d =date.getTime();
                java.sql.Date fecha =new java.sql.Date(d);

                String hora = tbHora.getText();
                boolean cancelado = false;
                boolean pagado = false;
                
                //Agregamos el Pedido

                Pedido pedido = new Pedido(mesero,mmss,fecha,hora,cancelado,pagado);
                pedidoData.guardarPedido(pedido);
                pnlMesas.removeAll();
                int capacidadSeleccionado = Integer.parseInt(cbCapacidad.getSelectedItem().toString());
                botonesMesas(capacidadSeleccionado);
//                idPedido = pedido.getIdPedido();
                SwingUtils.setEnableContainer(pnlProducto, true);
                SwingUtils.setEnableContainer(pnlDetalle, true);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Mesa mesa = mesaData.buscarMesa(btnMesaSeleccionada);
        
        Pedido pedido = pedidoData.buscarPedidoMesa(btnMesaSeleccionada);
       
        if(this.tDetalle.getRowCount()!=0){
            if(cbPagado.isSelected())
            {
                pedido.setPagado(true);
                pedidoData.actualizarPedido(pedido);
                mesa.setEstado(1);
                mesaData.actualizarMesa(mesa);
                RecargarPedido();
            }
            else
            {
                pedido.setPagado(false);
                pedidoData.actualizarPedido(pedido);
                mesa.setEstado(0);
                mesaData.actualizarMesa(mesa);
                RecargarPedido();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Agregue Productos ", "Error", JOptionPane.WARNING_MESSAGE);
        }
         
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Mesa m = mesaData.buscarMesa(btnMesaSeleccionada);
        try {
            if(m==null)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa ", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else if(tDetalle.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Ver Mesa", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
               
               
                for (int i = 0; i < tDetalle.getRowCount(); i++) {
                    Detalle detalle = detalleData.buscarDetalle(parseInt(tDetalle.getValueAt(i, 4).toString()));
                    Producto producto = productoData.buscarProducto(detalle.getProducto().getIdProducto());
                    
                    int cant = parseInt(tDetalle.getValueAt(i, 0).toString());
                    producto.setCantidad(cant+producto.getCantidad());
                    productoData.actualizarProducto(producto);
                    
                }
                Pedido pedido = pedidoData.buscarPedido(btnMesaSeleccionada);
                
                pedido.setCancelado(true);
                pedidoData.actualizarPedido(pedido);
                
                m.setEstado(1);
                
                mesaData.actualizarMesa(m);
                
                RecargarPedido();

            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnCambiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiar1ActionPerformed
        Mesa mesa;
        Pedido pedido; 
        try {
            if("".equals(tbActual.getText()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Mesa Ocupada");
            }
            else if("".equals(tbNueva.getText()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una Mesa Libre");
            }
            else
            {
                mesa = mesaData.buscarMesa(tbActual.getText());
                int idActual = mesa.getIdMesa();
                mesa.setEstado(1);
                mesaData.actualizarMesa(mesa);
                pedido=pedidoData.buscarPedidoMesa(idActual);
                
                mesa = mesaData.buscarMesa(tbNueva.getText());
                pedido.setMesa(mesa);
                pedidoData.actualizarPedido(pedido);
                mesa.setEstado(0);
                mesaData.actualizarMesa(mesa);
                JOptionPane.showMessageDialog(null, "Cambio de Mesa");
                RecargarPedido();
                
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiar1ActionPerformed

    private void btnActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualActionPerformed
        Mesa mmss = mesaData.buscarMesa(btnMesaSeleccionada);
        if(mmss == null)
        {
           JOptionPane.showMessageDialog(null, "Seleccione una Mesa");
        }
        else if(mmss.getEstado() == 1)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Ocupada");
        }
        else if(mmss.getEstado() == 2)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Ocupada");
        }
        else if(btnMesaSeleccionada == 0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa");
        }
        else
        {
             btnActual.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Actual_A.png")));
             tbActual.setText(tbNom.getText());
        }
    }//GEN-LAST:event_btnActualActionPerformed

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        Mesa mmss = mesaData.buscarMesa(btnMesaSeleccionada);
        if(mmss == null)
        {
           JOptionPane.showMessageDialog(null, "Seleccione una Mesa");
        }
        else if(mmss.getEstado() == 0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Libre");
        }
        else if(mmss.getEstado() == 2)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Libre");
        }
        else if(btnMesaSeleccionada == 0)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa");
        }
        else
        {
             btnNueva.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Nueva_A.png")));
             tbNueva.setText(tbNom.getText());
        }
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void tReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tReservaMousePressed
        
    }//GEN-LAST:event_tReservaMousePressed

    private void botonesCategoria()
    {
//        botonesCategoria.clear();
        CategoriaData mq = new CategoriaData(conexion);
        listaCategorias =(ArrayList)mq.obtenerCategorias();
        
        for(Categoria item:listaCategorias)
        {
            JButton boton = new JButton(item.getNombre());
            boton.setName(item.getIdCategoria()+"");
            
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setFont(new Font("", Font.BOLD, 12));
            boton.setPreferredSize(new Dimension(150, 20));
	
            

            boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.CENTER);

            pnlBotonesCategoria.add(boton);
            botonesCategoria.add(boton);
            
            pnlBotonesCategoria.updateUI();
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    botonesProducto(Integer.parseInt(boton.getName()));
                }
            });
                        
        }
    }
     int btnProductoSeleccionado=0;
    private void botonesProducto(int idCategoria)
    {
//        botonesProducto.clear();
        pnlBotonesProducto.removeAll();
        ProductoData mq = new ProductoData(conexion);
        listaProductos =(ArrayList)mq.listaProductoPorCategoria(idCategoria);
        
        for(Producto item:listaProductos)
        {
            JButton boton = new JButton();
            boton.setName(item.getIdProducto()+"");
            boton.setIcon(new ImageIcon(item.getImagen()));
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setFont(new Font("", Font.BOLD, 12));
            boton.setPreferredSize(new Dimension(100, 100));
           
            boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.CENTER);
             boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnProductoSeleccionado=Integer.parseInt(boton.getName());
                    tbStock.setText(item.getCantidad()+"");
                    tbPrecio.setText(item.getPrecio()+"");
                }
            });
            pnlBotonesProducto.add(boton);
            botonesProducto.add(boton);
            
            pnlBotonesProducto.updateUI();
           
        }
    }
    int btnMesaSeleccionada=0;
    private void botonesMesas(int capacidad)
    {
//        botonesMesa.clear();
        MesaData mq = new MesaData(conexion);
        listaMesas =(ArrayList)mq.obtenerMesaDetalleBotones(capacidad);
        
        for(Mesa item:listaMesas)
        {
            JButton boton = new JButton(item.getNombre());
            boton.setName(item.getIdMesa()+"");
            boton.setLayout(null);
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setFont(new Font("", Font.BOLD, 10));
            boton.setSize(new Dimension(100, 105));
            boton.setPreferredSize(new Dimension(100, 105));
            boton.setMaximumSize(new Dimension(100, 105));
            boton.setMinimumSize(new Dimension(100, 105));
//            boton.setBorderPainted(false);
            
//            boton.setContentAreaFilled(false);
            pnlMesas.add(boton);
            botonesMesa.add(boton);
            
            pnlMesas.updateUI();
            
             boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnMesaSeleccionada = Integer.parseInt(boton.getName());
                    tbNom.setText(boton.getText());
                    Reserva reserva = reservaData.buscarReservaPorMesaEstado(btnMesaSeleccionada);
                   
                    if(reserva != null)
                    {
                        cargarTablaReserva(btnMesaSeleccionada);
                    }
                   
                }
            });
            if(item.getEstado()==0)
            {
                boton.setBackground(Color.red);
                boton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Ocupada_A.png")));
            }
            if(item.getEstado()==1)
            {
                boton.setBackground(Color.green);
                boton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Libre_A.png")));
            }
            if(item.getEstado()==2)
            {   
                Reserva reserva = reservaData.buscarReservaPorMesa(item.getIdMesa());
                if(reserva == null)
                {
                    boton.setBackground(Color.green);
                    boton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Libre_A.png")));
                }
                else{
                    boton.setBackground(Color.yellow);
                    boton.setIcon(new ImageIcon(getClass().getResource("/imagenes/Mesa/Reservado_A.png")));
                }
            }
           boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.TOP);
        }
    }
    
    //Creamos la tabbla y llenamos
    private void cargarTablaMesero(){
        MeseroData mesero = new MeseroData(conexion);
        
        listaMeseros =(ArrayList)mesero.obtenerMesero();
        String[] columnName = {"Id","Nombre","DNI"};
        Object[][] rows = new Object[listaMeseros.size()][3];
        for(int i = 0; i < listaMeseros.size(); i++)
        {
            rows[i][0] = listaMeseros.get(i).getIdMesero();
            rows[i][1] = listaMeseros.get(i).getNombre();
            rows[i][2] = listaMeseros.get(i).getDni();    
        }
        
        TheModel model = new TheModel(rows, columnName);
        tMesero.setModel(model);
        tMesero.setRowHeight(20);
        
        
        tMesero.getColumnModel().getColumn(0).setMaxWidth(0);
        tMesero.getColumnModel().getColumn(0).setMinWidth(0);
        tMesero.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tMesero.getColumnModel().getColumn(2).setMaxWidth(0);
        tMesero.getColumnModel().getColumn(2).setMinWidth(0);
        tMesero.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    //Creamos la tabbla y llenamos
    public void cargarTablaDetalle(int p){
        double supTotal=0;
        DetalleData detalle = new DetalleData(conexion);
        
        listaDetalles =(ArrayList)detalle.obtenerDetalle(p);
        String[] columnName = {"CANT.", "DESCRIPCION", "P.UNIT", "IMPORTE","ID"};
        Object[][] rows = new Object[listaDetalles.size()][5];
        for(int i = 0; i < listaDetalles.size(); i++)
        {
            
            rows[i][0] = listaDetalles.get(i).getCantidad();
            rows[i][1] = listaDetalles.get(i).getProducto().getNombre();
            rows[i][2] = listaDetalles.get(i).getProducto().getPrecio();
            rows[i][3] = listaDetalles.get(i).getTotal();
            rows[i][4] = listaDetalles.get(i).getIdDetalle();
            supTotal += listaDetalles.get(i).getTotal();
           
        }
        tbTotal.setText(supTotal+"");
        TheModel model = new TheModel(rows, columnName);
        tDetalle.setModel(model);
        tDetalle.setRowHeight(20);
        
        
        tDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        tDetalle.getColumnModel().getColumn(1).setPreferredWidth(190);
        tDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        tDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        tDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
    }
    
    public void cargaCapacidadMesas()
    {
        MesaData mq = new MesaData(conexion);
        listaMesas =(ArrayList)mq.listaDeCapacidad();
        for(Mesa item:listaMesas)
        {
            cbCapacidad.addItem(item.getCapacidad());
        }
    }
    public void RecargarPedido()
    {
        Escritorio.removeAll();
        Escritorio.repaint();
          VistaPedido vr=new VistaPedido();
          vr.setVisible(true);
        Escritorio.add(vr);
        Escritorio.moveToFront(vr);
    }
    public void cargarTablaReserva(int idMesa){
        listaReservas =(ArrayList)reservaData.obtenerReservaPorMesa(idMesa);
        String[] columnName = {"IdR","IdC","IdM","nombre","Cliente","Mesa","Fecha","Hora"};
        Object[][] rows = new Object[listaReservas.size()][8];
        for(int i = 0; i < listaReservas.size(); i++)
        {
            rows[i][0] = listaReservas.get(i).getIdReserva();
            rows[i][1] = listaReservas.get(i).getCliente().getIdCliente();
            rows[i][2] = listaReservas.get(i).getMesa().getIdMesa();
            rows[i][3] = listaReservas.get(i).getCliente().getNombre()+" "+listaReservas.get(i).getCliente().getApellido();
            
            
            StringTokenizer tokens = new StringTokenizer(listaReservas.get(i).getMesa().getNombre());
            while(tokens.hasMoreTokens()){
                rows[i][5] = tokens.nextToken();
            }
            
            
            rows[i][6] = listaReservas.get(i).getFecha();
            rows[i][7] = listaReservas.get(i).getHora();
        }
        
        TheModel model = new TheModel(rows, columnName);
        tReserva.setModel(model);
        tReserva.setRowHeight(27);
        
        
        
        
        tReserva.getColumnModel().getColumn(0).setMaxWidth(0);
        tReserva.getColumnModel().getColumn(0).setMinWidth(0);
        tReserva.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tReserva.getColumnModel().getColumn(1).setMaxWidth(0);
        tReserva.getColumnModel().getColumn(1).setMinWidth(0);
        tReserva.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tReserva.getColumnModel().getColumn(2).setMaxWidth(0);
        tReserva.getColumnModel().getColumn(2).setMinWidth(0);
        tReserva.getColumnModel().getColumn(2).setPreferredWidth(0);
        
        tReserva.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        tReserva.getColumnModel().getColumn(4).setMaxWidth(0);
        tReserva.getColumnModel().getColumn(4).setMinWidth(0);
        tReserva.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        tReserva.getColumnModel().getColumn(6).setPreferredWidth(100);
        tReserva.getColumnModel().getColumn(7).setPreferredWidth(50);
        
        
    }
    
    DefaultTableModel temp;
    void LimpiarTabla(){
        try{
            temp = (DefaultTableModel) tReserva.getModel();
            int a =temp.getRowCount()-1;
            for(int i=0; i<a; i++)
                temp.removeRow(0); 
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActual;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCambiar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnVerMesa;
    private javax.swing.JComboBox<Integer> cbCapacidad;
    private javax.swing.JCheckBox cbPagado;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel pnlBotonesCategoria;
    private javax.swing.JPanel pnlBotonesProducto;
    private javax.swing.JPanel pnlCambio;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlMesas;
    private javax.swing.JPanel pnlProducto;
    private javax.swing.JPanel pnlReserva;
    private javax.swing.JSpinner sCantidad;
    private javax.swing.JTable tDetalle;
    private javax.swing.JTable tMesero;
    private javax.swing.JTable tReserva;
    private javax.swing.JTextField tbActual;
    private javax.swing.JTextField tbHora;
    private javax.swing.JTextField tbNom;
    private javax.swing.JTextField tbNueva;
    private javax.swing.JTextField tbPrecio;
    private javax.swing.JTextField tbStock;
    private javax.swing.JTextField tbTotal;
    // End of variables declaration//GEN-END:variables
}
