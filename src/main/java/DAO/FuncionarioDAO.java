package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public Funcionario create(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionarios (nome, email, senha) VALUES (?, ?, ?);";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getSenha());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    funcionario.setId(rs.getInt(1));
                }
                rs.close();
                return funcionario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar funcionário", e);
        }
    }

    public Funcionario update(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionarios SET nome = ?, email = ?, senha = ? WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getEmail());
            statement.setString(3, funcionario.getSenha());
            statement.setInt(4, funcionario.getId());

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                return funcionario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar funcionário", e);
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir funcionário", e);
        }
    }

    public void delete(Funcionario funcionario) {
        delete(funcionario.getId());
    }

    public Funcionario findById(Integer id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?;";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return resultSetToFuncionario(rs);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar funcionário por ID", e);
        }

        return null;
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionarios;";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = Conexao.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                funcionarios.add(resultSetToFuncionario(rs));
            }

            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar todos os funcionários", e);
        }
    }

    private Funcionario resultSetToFuncionario(ResultSet rs) throws SQLException {
        return new Funcionario(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("senha")
        );
    }
}
