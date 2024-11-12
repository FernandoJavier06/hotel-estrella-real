
package com.cunori.xml;

import com.cunori.models.Factura_;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author ferna
 */
public class GenerarXml {
    
    private String nombreDocumento;
    private String fechaEmision;
    private String correoReceptor;
    private String nitReceptor;
    private String nombreReceptor;
    private String direccionReceptor;
    private String codigoPostalReceptor;
    private String municipioReceptor;
    private String departamentoReceptor;
    private String cantidadItem[];
    private String descripcionItem[];
    private String precioUnitarioItem[];
    private String montoIvaItem[];
    private String montInguat[];
    private String montoGravable[];
    private String totalItem[];
    private String totalImpuestoIVA;
    private String totalImpuestoITH;
    private String granTotal;
    private int cantidadItems;
    public GenerarXml() {
    }

    public GenerarXml(String nombreDocumento, String fechaEmision, String correoReceptor, String nitReceptor, String nombreReceptor, String direccionReceptor, String codigoPostalReceptor, String municipioReceptor, String departamentoReceptor, String[] cantidadItem, String[] descripcionItem, String[] precioUnitarioItem, String[] montoIvaItem, String[] montInguat, String[] montoGravable, String[] totalItem, String totalImpuestoIVA, String totalImpuestoITH, String granTotal, int cantidadItems) {
        this.nombreDocumento = nombreDocumento;
        this.fechaEmision = fechaEmision;
        this.correoReceptor = correoReceptor;
        this.nitReceptor = nitReceptor;
        this.nombreReceptor = nombreReceptor;
        this.direccionReceptor = direccionReceptor;
        this.codigoPostalReceptor = codigoPostalReceptor;
        this.municipioReceptor = municipioReceptor;
        this.departamentoReceptor = departamentoReceptor;
        this.cantidadItem = cantidadItem;
        this.descripcionItem = descripcionItem;
        this.precioUnitarioItem = precioUnitarioItem;
        this.montoIvaItem = montoIvaItem;
        this.montInguat = montInguat;
        this.montoGravable = montoGravable;
        this.totalItem = totalItem;
        this.totalImpuestoIVA = totalImpuestoIVA;
        this.totalImpuestoITH = totalImpuestoITH;
        this.granTotal = granTotal;
        this.cantidadItems = cantidadItems;
    }

    

    

    
    public void crearXML(){
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        
        //Se crea el documento con el elemento raiz
        Document documento = implementation.createDocument(null, nombreDocumento, null);
        documento.setXmlVersion("1.0");
        
        Element GTDocumento = documento.createElement("dte:GTDocumento");
        GTDocumento.setAttribute("xmlns:ds", "http://www.w3.org/2000/09/xmldsig#");
        GTDocumento.setAttribute("xmlns:dte", "http://www.sat.gob.gt/dte/fel/0.2.0");
        GTDocumento.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        GTDocumento.setAttribute("Version", "0.1");
        GTDocumento.setAttribute("xsi:schemaLocation", "http://www.sat.gob.gt/dte/fel/0.2.0");
            
            Element SAT = documento.createElement("dte:SAT");
            SAT.setAttribute("ClaseDocumento", "dte");
            
                Element DTE = documento.createElement("dte:DTE");
                DTE.setAttribute("ID", "DatosCertificados");
                
                    Element DatosEmision = documento.createElement("dte:DatosEmision");
                    DatosEmision.setAttribute("ID", "DatosEmision");
                    
                        Element DatosGenerales = documento.createElement("dte:DatosGenerales");
                        DatosGenerales.setAttribute("CodigoMoneda", "GTQ");
                        DatosGenerales.setAttribute("FechaHoraEmision", fechaEmision);
                        DatosGenerales.setAttribute("Tipo", "FACT");
                        
                        DatosEmision.appendChild(DatosGenerales);
                        
                        Element Emisor = documento.createElement("dte:Emisor");
                        Emisor.setAttribute("AfiliacionIVA", "GEN");
                        Emisor.setAttribute("CodigoEstablecimiento", "1");
                        Emisor.setAttribute("CorreoEmisor", "demo@demo.com.gt");
                        Emisor.setAttribute("NITEmisor", "11111111111K");
                        Emisor.setAttribute("NombreComercial", "DEMO");
                        Emisor.setAttribute("NombreEmisor", "DEMO, SOCIEDAD ANONIMA");
                        
                            Element DireccionEmisor = documento.createElement("dte:DireccionEmisor");
                                Element DireccionE = documento.createElement("dte:Direccion");
                                Text textDireccionE = documento.createTextNode("CIUDAD");
                                DireccionE.appendChild(textDireccionE);
                                DireccionEmisor.appendChild(DireccionE);
                                
                                Element CodigoPostalE = documento.createElement("dte:CodigoPostal");
                                Text textCodigoPostalE = documento.createTextNode("20001");
                                CodigoPostalE.appendChild(textCodigoPostalE);
                                DireccionEmisor.appendChild(CodigoPostalE);
                                
                                Element MunicipioE = documento.createElement("dte:Municipio");
                                Text textMunicipioE = documento.createTextNode("CHIQUIMULA");
                                MunicipioE.appendChild(textMunicipioE);
                                DireccionEmisor.appendChild(MunicipioE);
                                
                                Element DepartamentoE = documento.createElement("dte:Departamento");
                                Text textDepartamentoE = documento.createTextNode("CHIQUIMULA");
                                DepartamentoE.appendChild(textDepartamentoE);
                                DireccionEmisor.appendChild(DepartamentoE);
                                
                                Element PaisE = documento.createElement("dte:Pais");
                                Text textPaisE = documento.createTextNode("GT");
                                PaisE.appendChild(textPaisE);
                                DireccionEmisor.appendChild(PaisE);
                          
                        DatosEmision.appendChild(Emisor);
                                
                        Element Receptor = documento.createElement("dte:Receptor");
                        Receptor.setAttribute("CorreoReceptor", correoReceptor);
                        Receptor.setAttribute("IDReceptor", nitReceptor);
                        Receptor.setAttribute("NombreReceptor", nombreReceptor);
                        
                            Element DireccionReceptor = documento.createElement("dte:DireccionReceptor");
                            
                                Element DireccionR = documento.createElement("dte:Direccion");
                                Text txtDireccionR = documento.createTextNode(direccionReceptor);
                                DireccionR.appendChild(txtDireccionR);
                                DireccionReceptor.appendChild(DireccionR);
                                
                                Element CodigoPostalR = documento.createElement("dte:CodigoPostal");
                                Text txtCodigoPostalR = documento.createTextNode(codigoPostalReceptor);
                                CodigoPostalR.appendChild(txtCodigoPostalR);
                                DireccionReceptor.appendChild(CodigoPostalR);
                                
                                Element MunicipioR = documento.createElement("dte:Municipio");
                                Text txtMunicipioR = documento.createTextNode(municipioReceptor);
                                MunicipioR.appendChild(txtMunicipioR);
                                DireccionReceptor.appendChild(MunicipioR);
                                
                                Element DepartamentoR = documento.createElement("dte:Departamento");
                                Text txtDepartamentoR = documento.createTextNode(departamentoReceptor);
                                DepartamentoR.appendChild(txtDepartamentoR);
                                DireccionReceptor.appendChild(DepartamentoE);
                                
                                Element PaisR = documento.createElement("dte:Pais");
                                Text txtPaisR = documento.createTextNode("GT");
                                PaisR.appendChild(txtPaisR);
                                DireccionReceptor.appendChild(PaisR);
                                
                        DatosEmision.appendChild(Receptor);
                                
                        Element Frases = documento.createElement("dte:Frases");
                            
                            Element Frase = documento.createElement("dte:Frase");
                            Frase.setAttribute("CodigoEscenario", "1");
                            Frase.setAttribute("TipoFrase", "1");
                            Frases.appendChild(Frase);
                        
                        DatosEmision.appendChild(Frases);
                        
                        Element Items = documento.createElement("dte:Items");
                        
                            for (int i = 0; i < cantidadItems; i++) {
                                Element Item = documento.createElement("dte:Item");
                                Item.setAttribute("BienOServicio", "S");
                                Item.setAttribute("NumeroLinea", String.valueOf(i+1));
                                
                                    Element Cantidad = documento.createElement("dte:Cantidad");
                                    Text txtCantidad = documento.createTextNode("1.00");
                                    Cantidad.appendChild(txtCantidad);
                                    Item.appendChild(Cantidad);
                                    
                                    Element UnidadMedida = documento.createElement("dte:UnidadMedida");
                                    Text txtUnidadMedida = documento.createTextNode("UND");
                                    UnidadMedida.appendChild(txtUnidadMedida);
                                    Item.appendChild(UnidadMedida);
                                    
                                    Element Descripcion = documento.createElement("dte:Descripcion");
                                    Text txtDescripcion = documento.createTextNode(descripcionItem[i]);
                                    Descripcion.appendChild(txtDescripcion);
                                    Item.appendChild(Descripcion);
                                    
                                    Element PrecioUnitario = documento.createElement("dte:PrecioUnitario");
                                    Text txtPrecioUnitario = documento.createTextNode(precioUnitarioItem[i]);
                                    PrecioUnitario.appendChild(txtPrecioUnitario);
                                    Item.appendChild(PrecioUnitario);
                                    
                                    Element Precio = documento.createElement("dte:Precio");
                                    Text txtPrecio = documento.createTextNode(precioUnitarioItem[i]);
                                    Precio.appendChild(txtPrecio);
                                    Item.appendChild(Precio);
                                    
                                    Element Descuento = documento.createElement("dte:Descuento");
                                    Text txtDescuento = documento.createTextNode("0.00");
                                    Descuento.appendChild(txtDescuento);
                                    Item.appendChild(Descuento);
                                
                                    Element Impuestos = documento.createElement("dte:Impuestos");
                                    
                                        Element ImpuestoIva = documento.createElement("dte:impuesto");
                                        
                                            Element NombreCortoIva = documento.createElement("dte:NombreCorto");
                                            Text txtNombreCortoIva = documento.createTextNode("IVA");
                                            NombreCortoIva.appendChild(txtNombreCortoIva);
                                            ImpuestoIva.appendChild(NombreCortoIva);
                                            
                                            Element CodigoUnidadGravableIva = documento.createElement("dte:CodigoUnidadGravable");
                                            Text txtCodigoUnidadGravable = documento.createTextNode("1");
                                            CodigoUnidadGravableIva.appendChild(txtCodigoUnidadGravable);
                                            ImpuestoIva.appendChild(CodigoUnidadGravableIva);
                                            
                                            Element MontoGravableIva = documento.createElement("dte:MontoGravable");
                                            Text txtMontoGravableIva = documento.createTextNode(montoGravable[i]);
                                            MontoGravableIva.appendChild(txtMontoGravableIva);
                                            ImpuestoIva.appendChild(MontoGravableIva);
                                            
                                            Element MontoImpuestoIva = documento.createElement("dte:MontoImpuesto");
                                            Text txtMontoImpuestoIva = documento.createTextNode(montoIvaItem[i]);
                                            MontoImpuestoIva.appendChild(txtMontoImpuestoIva);
                                            ImpuestoIva.appendChild(MontoImpuestoIva);
                                        
                                        Impuestos.appendChild(ImpuestoIva);
                                            
                                        Element ImpuestoITH = documento.createElement("dte:impuesto");
                                            
                                            Element NombreCortoITH = documento.createElement("dte:NombreCorto");
                                            Text txtNombreCortoITH = documento.createTextNode("ITH");
                                            NombreCortoITH.appendChild(txtNombreCortoITH);
                                            ImpuestoITH.appendChild(NombreCortoITH);
                                            
                                            Element CodigoUnidadGravableITH = documento.createElement("dte:CodigoUnidadGravable");
                                            Text txtCodigoUnidadGravableITH = documento.createTextNode("1");
                                            CodigoUnidadGravableITH.appendChild(txtCodigoUnidadGravableITH);
                                            ImpuestoITH.appendChild(CodigoUnidadGravableITH);
                                            
                                            Element MontoGravableITH = documento.createElement("dte:MontoGravable");
                                            Text txtMontoGravableITH = documento.createTextNode(montoGravable[i]);
                                            MontoGravableITH.appendChild(txtMontoGravableITH);
                                            ImpuestoITH.appendChild(MontoGravableITH);
                                            
                                            Element MontoImpuestoITH = documento.createElement("dte:MontoImpuesto");
                                            Text txtMontoImpuestoITH = documento.createTextNode(montInguat[i]);
                                            MontoImpuestoITH.appendChild(txtMontoImpuestoITH);
                                            ImpuestoITH.appendChild(MontoImpuestoITH);
                                            
                                        Impuestos.appendChild(ImpuestoITH);
                                    
                                    Item.appendChild(Impuestos);
                                    
                                    Element Total = documento.createElement("dte:Total");
                                    Text txtTotal = documento.createTextNode(totalItem[i]);
                                    Total.appendChild(txtTotal);
                                    Item.appendChild(Total);
                                    
                            Items.appendChild(Item);          
                            }
                        DatosEmision.appendChild(Items);
                        
                        Element Totales = documento.createElement("dte:Totales");
                        
                            Element TotalImpuestos = documento.createElement("dte:TotalImpuestos");
                            
                                Element TotalImpuestoIva = documento.createElement("dte:TotalImpuesto");
                                TotalImpuestoIva.setAttribute("NombreCorto", "IVA");
                                TotalImpuestoIva.setAttribute("TotalMontoImpuesto", totalImpuestoIVA);
                                TotalImpuestos.appendChild(TotalImpuestoIva);
                                
                                Element TotalImpuestoIth = documento.createElement("dte:TotalImpuesto");
                                TotalImpuestoIth.setAttribute("NombreCorto", "ITH");
                                TotalImpuestoIth.setAttribute("TotalMontoImpuesto", totalImpuestoITH);
                                TotalImpuestos.appendChild(TotalImpuestoIth);
                                    
                            Totales.appendChild(TotalImpuestos);
                            
                            Element GranTotal = documento.createElement("dte:GranTotal");
                            Text txtGranTotal = documento.createTextNode(granTotal);
                            GranTotal.appendChild(txtGranTotal);
                            Totales.appendChild(GranTotal);
                        
                        DatosEmision.appendChild(Totales);
                        
                    DTE.appendChild(DatosEmision);
                
                SAT.appendChild(DTE);
                
            GTDocumento.appendChild(SAT);
        
        documento.getDocumentElement().appendChild(GTDocumento);
        
        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(nombreDocumento + ".xml"));
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        }
        catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void setTotalImpuestoIVA(String totalImpuestoIVA) {
        this.totalImpuestoIVA = totalImpuestoIVA;
    }

    public void setTotalImpuestoITH(String totalImpuestoITH) {
        this.totalImpuestoITH = totalImpuestoITH;
    }
    
    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }
    
    
    
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public void setNitReceptor(String nitReceptor) {
        this.nitReceptor = nitReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public void setDireccionReceptor(String direccionReceptor) {
        this.direccionReceptor = direccionReceptor;
    }

    public void setCodigoPostalReceptor(String codigoPostalReceptor) {
        this.codigoPostalReceptor = codigoPostalReceptor;
    }

    public void setMunicipioReceptor(String municipioReceptor) {
        this.municipioReceptor = municipioReceptor;
    }

    public void setDepartamentoReceptor(String departamentoReceptor) {
        this.departamentoReceptor = departamentoReceptor;
    }

    public void setCantidadItem(String[] cantidadItem) {
        this.cantidadItem = cantidadItem;
    }

    public void setDescripcionItem(String[] descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public void setPrecioUnitarioItem(String[] precioUnitarioItem) {
        this.precioUnitarioItem = precioUnitarioItem;
    }

    public void setMontoIvaItem(String[] montoIvaItem) {
        this.montoIvaItem = montoIvaItem;
    }

    public void setMontInguat(String[] montInguat) {
        this.montInguat = montInguat;
    }

    public void setMontoGravable(String[] montoGravable) {
        this.montoGravable = montoGravable;
    }

    public void setTotalItem(String[] totalItem) {
        this.totalItem = totalItem;
    }


    public void setGranTotal(String granTotal) {
        this.granTotal = granTotal;
    }

    
    
}
