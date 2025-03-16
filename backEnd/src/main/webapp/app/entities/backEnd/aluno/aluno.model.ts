import dayjs from 'dayjs/esm';

export interface IAluno {
  id: number;
  nome?: string | null;
  email?: string | null;
  dtNascimento?: dayjs.Dayjs | null;
  cpf?: string | null;
}

export type NewAluno = Omit<IAluno, 'id'> & { id: null };
