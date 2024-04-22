export interface AgendamentoInterface {
    agendamentoId: number,
    clienteId: number,
    empresaId: number,
    servicoId: number,
    funcionarioId: number,
    data: Date,
    horario: Date,
    ativo: boolean
}
