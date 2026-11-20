import heroImage from '../assets/fachada.png'
import { useState } from 'react'

function HeroSection() {
  const [showReservationForm, setShowReservationForm] = useState(false)
  const [submitted, setSubmitted] = useState(false)

  function handleSubmit(event) {
    event.preventDefault()
    setSubmitted(true)
  }

  return (
    <section
      id="inicio"
      className="hero-section"
      style={{ backgroundImage: `linear-gradient(90deg, rgba(18, 32, 42, 0.60), rgba(18, 32, 42, 0.92)), url(${heroImage})` }}
    >
      <div className="hero-content">
        {showReservationForm ? (
          <div className="reservation-form-panel">
            <p className="eyebrow">Residencia universitaria</p>
            <h1>Solicitud de reserva</h1>
            {submitted ? (
              <p className="reservation-success" role="status">
                Gracias. Tu solicitud se ha validado en este formulario, pero todavía no se ha enviado a la residencia.
              </p>
            ) : (
              <form className="reservation-form" onSubmit={handleSubmit}>
                <label>
                  Nombre
                  <input name="nombre" autoComplete="given-name" required />
                </label>
                <label>
                  Apellidos
                  <input name="apellidos" autoComplete="family-name" required />
                </label>
                <label>
                  Fecha de nacimiento
                  <input name="fechaNacimiento" type="date" autoComplete="bday" required />
                </label>
                <label>
                  Estudios a realizar
                  <input name="estudios" required />
                </label>
                <label>
                  Fecha prevista de entrada
                  <input
                      name="fechaEntrada"
                      type="date"
                      min="2027-05-01"
                      required
                  />
                </label>
                <label>
                  Tipo de habitación
                  <select name="tipoHabitacion" className="form-input" required>
                    <option value="">Seleccionar</option>
                    <option value="normal">Basic</option>
                    <option value="premium">Premium</option>
                  </select>
                </label>

                <label>
                  Correo electrónico
                  <input name="correo" type="email" autoComplete="email" required />
                </label>
                <label>
                  Teléfono
                  <input name="telefono" type="tel" autoComplete="tel" required />
                </label>
                <label className="reservation-consent">
                  <input name="consentimiento" type="checkbox" required />
                  <span>Consiento la cesión de los datos personales a Domus Universia.</span>
                </label>
                <div className="detailsTecsanit">Responsable: Tecsanit, S.L. Finalidad: gestionar tu solicitud de prereserva y contactar contigo.
                  Legitimación: aplicación de medidas precontractuales solicitadas por ti (art. 6.1.b RGPD).
                  Destinatarios: proveedores necesarios para prestar el servicio, bajo las garantías legales correspondientes.
                  Conservación: durante el tiempo necesario para gestionar la solicitud y atender posibles responsabilidades legales.
                  Puedes ejercer tus derechos escribiendo a privacy@domusuniversia.com</div>
                <details className="privacy-details">
                  <summary>Consulta nuestra Política de Privacidad para obtener toda la información sobre el tratamiento de tus datos.</summary>
                  <div className="privacy-full-text">

                    <h3>POLÍTICA DE PRIVACIDAD</h3>
                    <h3>Solicitudes de prereserva de alojamiento</h3>

                    <p><strong>Última actualización:</strong> 20 de noviembre de 2026</p>

                    <h3>1. Responsable del tratamiento</h3>

                    <p>El responsable del tratamiento de los datos personales facilitados a través del formulario de
                      prereserva es:</p>

                    <ul>
                      <li><strong>Razón social:</strong> TECSANIT, S.L.</li>
                      <li><strong>CIF:</strong> B56192511</li>
                      <li><strong>Domicilio social:</strong> Calle Ánade 3, 28939 Batres, España.</li>
                      <li><strong>Correo electrónico de contacto:</strong> privacy@domusuniversia.com</li>
                    </ul>

                    <p>La sociedad es responsable del tratamiento de los datos personales que los usuarios facilitan a
                      través del formulario de solicitud de prereserva de alojamiento de la residencia.</p>

                    <h3>2. Finalidad del tratamiento</h3>

                    <p>Los datos personales facilitados por el usuario serán tratados con las siguientes
                      finalidades:</p>

                    <ul>
                      <li>Gestionar las solicitudes de prereserva de alojamiento.</li>
                      <li>Comprobar la disponibilidad de habitaciones y las características del alojamiento
                        solicitado.
                      </li>
                      <li>Contactar con el interesado para atender su solicitud y facilitarle información sobre las
                        condiciones, tarifas y características del alojamiento.
                      </li>
                      <li>Resolver las consultas relacionadas con la posible contratación de una plaza en la
                        residencia.
                      </li>
                      <li>Realizar las actuaciones necesarias para una eventual formalización de la reserva, cuando el
                        interesado decida continuar con el proceso.
                      </li>
                    </ul>

                    <p>Los datos no serán utilizados para enviar publicidad o comunicaciones comerciales no
                      solicitadas.</p>

                    <h3>3. Base jurídica del tratamiento</h3>

                    <p>La base jurídica que legitima el tratamiento de los datos es la aplicación de medidas
                      precontractuales a petición del interesado, de conformidad con el artículo 6.1.b del Reglamento
                      (UE) 2016/679, General de Protección de Datos (RGPD).</p>

                    <p>El usuario facilita voluntariamente sus datos con la finalidad de solicitar información y
                      manifestar su interés en una posible reserva de alojamiento.</p>

                    <p>Por tanto, no es necesario recabar un consentimiento adicional para gestionar la solicitud de
                      prereserva, siempre que el tratamiento se limite a las finalidades descritas.</p>

                    <h3>4. Categorías de datos tratados</h3>

                    <p>Los datos personales que podrán tratarse son:</p>

                    <ul>
                      <li>Datos identificativos: nombre y apellidos.</li>
                      <li>Datos de contacto: dirección de correo electrónico y número de teléfono.</li>
                      <li>Datos relacionados con la solicitud: universidad o centro de estudios, fechas previstas de
                        entrada y salida, tipo de habitación solicitada y preferencias relacionadas con el alojamiento.
                      </li>
                      <li>Cualquier otra información que el usuario facilite voluntariamente en el apartado de
                        observaciones.
                      </li>
                    </ul>

                    <p>La empresa no solicita inicialmente datos bancarios, documentación identificativa ni categorías
                      especiales de datos personales a través del formulario de prereserva.</p>

                    <p>Se recomienda no incluir información especialmente sensible en el apartado de observaciones.</p>

                    <h3>5. Destinatarios de los datos</h3>

                    <p>Los datos personales podrán ser accesibles por proveedores que presten servicios necesarios para
                      el funcionamiento y la gestión de la solicitud, tales como:</p>

                    <ul>
                      <li>Proveedores de alojamiento y mantenimiento de la página web.</li>
                      <li>Proveedores de servicios de correo electrónico y comunicaciones.</li>
                      <li>Proveedores de herramientas de gestión de solicitudes o clientes (CRM), si se utilizan.</li>
                      <li>Personal autorizado de la empresa encargado de gestionar las solicitudes.</li>
                    </ul>

                    <p>Estos proveedores actuarán, cuando corresponda, como encargados del tratamiento y estarán sujetos
                      a las obligaciones y garantías establecidas en el RGPD.</p>

                    <p>Los datos no se comunicarán a terceros para sus propios fines comerciales, salvo que exista una
                      base jurídica que lo permita o una obligación legal.</p>

                    <h3>6. Transferencias internacionales de datos</h3>

                    <p>Con carácter general, no se prevé realizar transferencias internacionales de datos fuera del
                      Espacio Económico Europeo.</p>

                    <p>No obstante, si alguno de los proveedores tecnológicos utilizados por la empresa trata datos
                      desde países situados fuera de dicho espacio, se adoptarán las garantías exigidas por la normativa
                      vigente, incluyendo, cuando corresponda, decisiones de adecuación o cláusulas contractuales
                      tipo.</p>

                    <p>La información concreta sobre los proveedores y las transferencias aplicables podrá solicitarse a
                      través de los medios de contacto indicados en esta política.</p>

                    <h3>7. Plazo de conservación de los datos</h3>

                    <p>Los datos personales se conservarán durante el tiempo necesario para gestionar la solicitud de
                      prereserva y mantener las comunicaciones relacionadas con ella.</p>

                    <p>Cuando la solicitud haya sido atendida y no se formalice una reserva, los datos personales se
                      conservarán durante un plazo máximo de seis meses desde la última interacción con el interesado.
                      Transcurrido dicho plazo, los datos serán suprimidos, salvo que exista una obligación legal de conservación
                      o resulte necesario mantenerlos bloqueados para atender posibles responsabilidades legales.</p>

                    <p>Cuando se formalice una reserva, los datos necesarios podrán incorporarse a los tratamientos
                      asociados a la relación contractual, aplicándose los plazos de conservación correspondientes.</p>

                    <p>En todo caso, los datos podrán mantenerse debidamente bloqueados durante los plazos legalmente
                      establecidos para atender posibles responsabilidades derivadas del tratamiento.</p>

                    <h3>8. Derechos de los usuarios</h3>

                    <p>El interesado puede ejercer en cualquier momento los siguientes derechos:</p>

                    <ul>
                      <li><strong>Acceso:</strong> conocer qué datos personales está tratando la empresa.</li>
                      <li><strong>Rectificación:</strong> solicitar la corrección de datos inexactos o incompletos.</li>
                      <li><strong>Supresión:</strong> solicitar la eliminación de sus datos cuando proceda.</li>
                      <li><strong>Oposición:</strong> oponerse a determinados tratamientos cuando concurran los
                        requisitos legales.
                      </li>
                      <li><strong>Limitación:</strong> solicitar que se limite el tratamiento en los supuestos previstos
                        legalmente.
                      </li>
                      <li><strong>Portabilidad:</strong> recibir sus datos en un formato estructurado y de uso común
                        cuando resulte aplicable.
                      </li>
                    </ul>

                    <p>Para ejercer estos derechos, el usuario podrá enviar una solicitud a:</p>

                    <p><strong>Correo electrónico:</strong> <a
                        href="mailto:privacy@domusuniversia.com">privacy@domusuniversia.com</a></p>

                    <p><strong>Dirección postal:</strong> TECSANIT, S.L., Calle Ánade 3, 28939 Batres, España.</p>

                    <p>La solicitud deberá identificar el derecho que desea ejercer. Cuando resulte necesario, la
                      empresa podrá solicitar información adicional para verificar la identidad del solicitante.</p>

                    <p>Asimismo, el interesado tiene derecho a presentar una reclamación ante la Agencia Española de
                      Protección de Datos (AEPD), a través de <a href="https://www.aepd.es" target="_blank"
                                                                 rel="noopener noreferrer">www.aepd.es</a>, si considera
                      que sus derechos no han sido atendidos adecuadamente.</p>

                    <h3>9. Seguridad y confidencialidad</h3>

                    <p>La empresa adopta las medidas técnicas y organizativas apropiadas para garantizar un nivel de
                      seguridad adecuado al riesgo, con el objetivo de proteger los datos personales frente a accesos no
                      autorizados, pérdida, alteración, divulgación o destrucción accidental o ilícita.</p>

                    <p>El acceso a los datos estará limitado al personal y a los proveedores que necesiten conocerlos
                      para desarrollar las funciones relacionadas con la gestión de las solicitudes.</p>

                    <h3>10. Carácter obligatorio de los datos</h3>

                    <p>Los campos identificados como obligatorios en el formulario son necesarios para poder gestionar
                      la solicitud de prereserva y contactar con el interesado.</p>

                    <p>La negativa a facilitar los datos imprescindibles impedirá atender adecuadamente la
                      solicitud.</p>

                    <p>Los campos opcionales podrán dejarse sin cumplimentar sin que ello impida enviar el formulario,
                      siempre que se hayan facilitado los datos necesarios.</p>

                    <h3>11. Comunicaciones comerciales</h3>

                    <p>La empresa no utilizará los datos obtenidos mediante el formulario para enviar comunicaciones
                      comerciales, promociones o publicidad no solicitada.</p>

                    <p>Si en el futuro se desea realizar este tipo de comunicaciones, se solicitará la correspondiente
                      autorización cuando sea legalmente necesaria, mediante un mecanismo independiente, específico y
                      voluntario.</p>

                    <h3>12. Modificaciones de la política de privacidad</h3>

                    <p>La empresa podrá actualizar esta política de privacidad cuando resulte necesario para adaptarla a
                      cambios normativos, organizativos o en los tratamientos de datos realizados.</p>

                    <p>La versión vigente estará siempre disponible en la página web de la residencia.</p>

                    <hr/>

                    <p><strong>Responsable del tratamiento:</strong> TECSANIT, S.L.</p>
                    <p><strong>CIF:</strong> B56192511</p>
                    <p><strong>Domicilio social:</strong> Calle Ánade 3, 28939 Batres, España.</p>
                    <p><strong>Correo electrónico:</strong> <a
                        href="mailto:privacy@domusuniversia.com">privacy@domusuniversia.com</a></p>
                    <p><strong>Página web:</strong> <a href="https://www.domusuniversia.com" target="_blank"
                                                       rel="noopener noreferrer">www.domusuniversia.com</a></p>

                  </div>
                </details>
                <div className="reservation-form-actions">
                  <button className="secondary-button" type="button" onClick={() => {
                    setShowReservationForm(false);
                    setSubmitted(false)
                  }}>
                    Volver
                  </button>
                  <button className="primary-button" type="submit">Enviar solicitud</button>
                </div>
              </form>
            )}
          </div>
        ) : (
            <>

              <p className="eyebrow">Residencia universitaria</p>
              <h1>Un lugar comodo para estudiar, convivir y sentirte en casa</h1>
              <p className="hero-copy">
                Habitaciones preparadas para el ritmo universitario, zonas comunes cuidadas y un equipo cercano para
                acompanar tu estancia.
              </p>
              <div className="hero-actions">
                <a className="secondary-button" href="#contacto">
                  Solicitar informacion
                </a>
                <button className="primary-button" type="button" onClick={() => setShowReservationForm(true)}>
                  Reserva ya tu plaza
                </button>
                { /*<a className="secondary-button" href="#servicios">
            Ver servicios
          </a>*/}

              </div>
            </>
        )}
      </div>
    </section>
  )
}

export default HeroSection
